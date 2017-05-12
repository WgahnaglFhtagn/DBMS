
package vasin.Entities.Book;

import Entities.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class BooksModel extends AbstractTableModel {

    List<Book> list = new ArrayList<>();
    Connection c;

    public BooksModel(Connection c) throws SQLException {
        super();
        this.c = c;
        selectBook(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        selectBook(c);
        rowsCount = list.size();
    }
    int rowsCount = 5;
    int colCount = 6;

    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM section "
                            + "where id=" + list.get(rowIndex).getSectionId() + ";");
                    rs.next();
                    s = rs.getString("name");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getDescription();
            case 3:
                return list.get(rowIndex).getCostPrice();
            case 4:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM author "
                            + "where id=" + list.get(rowIndex).getAuthorId() 
                            + ";");
                    rs.next();
                    s = rs.getString("full_name");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 5:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM user1 "
                            + "where id=" + list.get(rowIndex).getAuthorId() 
                            + ";");
                    rs.next();
                    s = rs.getString("full_name");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "section";
            case 1:
                return "name";
            case 2:
                return "description";
            case 3:
                return "cost_price";
            case 4:
                return "author";
            case 5:
                return "user";
        }
        return null;
    }

    public Book getSelectesItem(int row) {
        return list.get(row);
    }
    
    public static List<Book> selectBook(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Book> books = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM book");

            while (rs.next()) {
                Book item = new Book(rs.getInt("id"), rs.getInt("sectionid")
                        , rs.getString("name"), rs.getString("description")
                        , rs.getInt("cost_price"), rs.getInt("authorid")
                        , rs.getInt("userid"));
                books.add(item);
            }
            return books;
    }
    
    public static Book selectBookById(Connection c, int id) throws SQLException{
        Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Book WHERE id = "+id );
            Book books = null;
            while (rs.next()) {
               books= new Book(rs.getInt("id"), rs.getInt("sectionid")
                        , rs.getString("name"), rs.getString("description")
                        , rs.getInt("cost_price"), rs.getInt("authorid")
                        , rs.getInt("userid"));
            }
            return books;
    }
}
