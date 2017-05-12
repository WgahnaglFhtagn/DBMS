package vasin.Entities.Section;

import Entities.Section;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SectionsModel extends AbstractTableModel {
    List<Section> list = new ArrayList<>();

    Connection c;

    public SectionsModel(Connection c) throws SQLException {
        super();
        this.c = c;
        selectSection(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        selectSection(c);
        rowsCount = list.size();
    }
    int rowsCount = 5;
    int colCount = 2;

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
                return list.get(rowIndex).getName();
            case 1:
                return list.get(rowIndex).getDescription();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name";
            case 1:
                return "Description";
        }
        return null;
    }

    public Section getSelectesItem(int row) {
        return list.get(row);
    }
    
    public static List<Section> selectSection(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Section> sections = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Section");
            while (rs.next()) {
                Section item = new Section(rs.getInt("ID"), rs.getString("Name"), 
                        rs.getString("Description"));

                sections.add(item);
            }
            return sections;
    }
    
    public static Section selectOrderById(Connection c, int id) throws SQLException{
        Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM order WHERE id = "+id );
            Section sections = null;
            while (rs.next()) {
               sections = new Section(rs.getInt("ID"), rs.getString("Name"), 
                        rs.getString("Description"));
            }
            return sections;
    }
}
