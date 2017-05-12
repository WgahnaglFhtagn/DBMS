package vasin.Entities.Order;

import Entities.Book;
import Entities.Order;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewOrder extends javax.swing.JDialog {

    Connection c;
    Order editItem;
    List<Book> list;
    List<Book> list1;

    public NewOrder(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        this.c = c;

        ((AbstractDocument) date.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) number.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM book");
            while (rs.next()) {
                Book tmp = new Book(rs.getInt("id"), rs.getInt("sectionid"), 
                        rs.getString("name"), rs.getString("description"), 
                        rs.getInt("cost_price"), rs.getInt("authorid"), rs.getInt("userid"));
                list.add(tmp);
                list1.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        bookid.setModel(new DefaultComboBoxModel(list.toArray()));
    }

    public NewOrder(java.awt.Frame parent, boolean modal, Connection c, Order u) {
        super(parent, modal);
        initComponents();
        this.c = c;
        editItem = u;

        ((AbstractDocument) date.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) number.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM book");
            while (rs.next()) {
                Book tmp = new Book(rs.getInt("id"), rs.getInt("sectionid"), 
                        rs.getString("name"), rs.getString("description"), 
                        rs.getInt("cost_price"), rs.getInt("authorid"), 
                        rs.getInt("userid"));
                list.add(tmp);
                list1.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        bookid.setModel(new DefaultComboBoxModel(list.toArray()));
        fillFields();
    }

    private void fillFields() {
        date.setText(editItem.getDate());
        number.setText(String.valueOf(editItem.getNumber()));
        bookid.setSelectedItem(-1);
        for (Book s : list) {
            if (s.getId() == editItem.getBookid()) {
                bookid.setSelectedItem((s));
            }
        }
        for (Book s : list1) {
            if (s.getId() == editItem.getBookid()) {
                bookid.setSelectedItem((s));
            }
        }
    }

    public boolean check() {
        if ("".equals(number.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "number has wrong format");
            return false;
        }
        if ("".equals(date.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "date cannot be empty");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bookid = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NewOrder");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("date");

        jLabel3.setText("number");

        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });

        jLabel5.setText("book");

        bookid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(number)
                    .addComponent(bookid, 0, 130, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        number.getAccessibleContext().setAccessibleName("");
        number.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!check()) {
            return;
        }
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into order1 "
                        + "(date,number,total_price,bookid) values ('" 
                        + date.getText() + "','" + number.getText() + "','" 
                        + ((Book) bookid.getSelectedItem()).getId() * Integer.valueOf(number.getText()) 
                        + "','" + ((Book) bookid.getSelectedItem()).getId() 
                        + "');");
            } else {
                statement.executeUpdate("update order1 set date='" 
                        + date.getText() + "',number='" + number.getText() 
                        + "',total_price='" 
                        + ((Book) bookid.getSelectedItem()).getId() * Integer.valueOf(number.getText()) 
                        + "',bookid='" + ((Book) bookid.getSelectedItem()).getId() 
                        + "' where id=" + editItem.getId() + ";");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed

    }//GEN-LAST:event_numberActionPerformed

    private void bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookidActionPerformed

    }//GEN-LAST:event_bookidActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bookid;
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField number;
    // End of variables declaration//GEN-END:variables
}
