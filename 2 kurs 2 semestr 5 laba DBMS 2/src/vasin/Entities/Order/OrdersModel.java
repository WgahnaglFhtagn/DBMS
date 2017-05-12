
package vasin.Entities.Order;

import Entities.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class OrdersModel extends AbstractTableModel {

    List<Order> list = new ArrayList<>();
    Connection c;

    public OrdersModel(Connection c) throws SQLException {
        super();
        this.c = c;
        selectOrder(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        selectOrder(c);
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
        String s = "";
        int i = 0;
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getDate();
            case 1:
                return list.get(rowIndex).getNumber();
            case 2:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM book where id=" 
                            + list.get(rowIndex).getBookid() + ";");
                    rs.next();
                    i = rs.getInt("cost_price") * list.get(rowIndex).getNumber();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return i;
            case 3:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM book where id=" 
                            + list.get(rowIndex).getBookid() + ";");
                    rs.next();
                    s = rs.getString("name");
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
                return "date";
            case 1:
                return "number";
            case 2:
                return "total_price";
            case 3:
                return "book";
        }
        return null;
    }

    public Order getSelectesItem(int row) {
        return list.get(row);
    }
    
    public static List<Order> selectOrder(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Order> orders = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM order1");

            while (rs.next()) {
                Order item = new Order(rs.getInt("id"), rs.getString("date")
                        , rs.getInt("number"), rs.getInt("total_price")
                        , rs.getInt("bookid"));
                orders.add(item);
            }
            return orders;
    }
    
    public static Order selectOrderById(Connection c, int id) throws SQLException{
        Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM order WHERE id = "+id );
            Order orders = null;
            while (rs.next()) {
               orders= new Order(rs.getInt("id"), rs.getString("date")
                        , rs.getInt("number"), rs.getInt("total_price")
                        , rs.getInt("bookid"));
            }
            return orders;
    }
}
