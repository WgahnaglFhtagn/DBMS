package vasin.Entities.User;

import Entities.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsersModel extends AbstractTableModel {
    List<User> list = new ArrayList<>();

    Connection c;

    public UsersModel(Connection c) throws SQLException {
        super();
        this.c = c;
        selectUser(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
            list = new ArrayList<>();
            selectUser(c);
        rowsCount = list.size();
    }
    int rowsCount = 5;
    int colCount = 5;

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
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getFullName();
            case 2:
                return list.get(rowIndex).getContactNumber();
            case 3:
                return list.get(rowIndex).getAddress();
            case 4:
                return list.get(rowIndex).getNickName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "Full_name";
            case 2:
                return "Contact_number";
            case 3:
                return "Address";
            case 4:
                return "Nickname";
        }
        return null;
    }

    public User getSelectesItem(int row) {
        return list.get(row);
    }
    
    public static List<User> selectUser(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<User> users = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM user1");
            while (rs.next()) {
                User item = new User(rs.getInt("id"), rs.getString("Full_name"), 
                        rs.getString("Contact_number"), rs.getString("Address"), 
                        rs.getString("Nickname"));
                users.add(item);
            }
            return users;
    }
    
    public static User selectOrderById(Connection c, int id) throws SQLException{
        Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM order WHERE id = "+id );
            User users = null;
            while (rs.next()) {
               users = new User(rs.getInt("id"), rs.getString("Full_name"), 
                        rs.getString("Contact_number"), rs.getString("Address"), 
                        rs.getString("Nickname"));            }
            return users;
    }
}
