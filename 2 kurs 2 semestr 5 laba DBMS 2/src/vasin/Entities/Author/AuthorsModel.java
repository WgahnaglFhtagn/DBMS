package vasin.Entities.Author;

import Entities.Author;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AuthorsModel extends AbstractTableModel {
    List<Author> list = new ArrayList<>();

    Connection c;

    public AuthorsModel(Connection c) throws SQLException {
        super();
        this.c = c;
        selectAuthor(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
            list = new ArrayList<>();
            selectAuthor(c);
        rowsCount = list.size();
    }
    int rowsCount = 5;
    int colCount = 4;

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
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getFullName();
            case 1:
                return list.get(rowIndex).getContactNumber();
            case 2:
                return list.get(rowIndex).getAddress();
            case 3:
                return list.get(rowIndex).getNumberOfWorks();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "full_name";
            case 1:
                return "contact_number";
            case 2:
                return "address";
            case 3:
                return "number_of_works";
        }
        return null;
    }

    public Author getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Author> selectAuthor(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Author> authors = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Author");
            while (rs.next()) {
                Author item = new Author(rs.getInt("ID"), rs.getString("Full_name"), 
                        rs.getString("Contact_number"), rs.getString("Address"), 
                        rs.getInt("Number_of_works"));

                authors.add(item);
            }
            return authors;
    }
    
        public static Author selectAuthorById(Connection c, int id) throws SQLException{
        Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Author WHERE id = "+id );
            Author autor = null;
            while (rs.next()) {
               autor = new Author(rs.getInt("ID"), rs.getString("Full_name"), 
                        rs.getString("Contact_number"), rs.getString("Address"), 
                        rs.getInt("Number_of_works"));
            }
            return autor;
    }
}
