package vasin.Entities.User;

import Entities.User;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewUser extends javax.swing.JDialog {

    Connection c;
    User editItem;

    public NewUser(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        this.c = c;

        ((AbstractDocument) id.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) fullName.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) contactNumber.getDocument()).setDocumentFilter(new JTextFieldLimit(15));
        ((AbstractDocument) address.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) nickName.getDocument()).setDocumentFilter(new JTextFieldLimit(15));
    }

    public NewUser(java.awt.Frame parent, boolean modal, Connection c, User u) {
        super(parent, modal);
        initComponents();
        this.c = c;
        editItem = u;

        ((AbstractDocument) id.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) fullName.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) contactNumber.getDocument()).setDocumentFilter(new JTextFieldLimit(15));
        ((AbstractDocument) address.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) nickName.getDocument()).setDocumentFilter(new JTextFieldLimit(15));
        fillFields();
    }

    private void fillFields() {
        id.setText(String.valueOf(editItem.getId()));
        fullName.setText(editItem.getFullName());
        contactNumber.setText(String.valueOf(editItem.getContactNumber()));
        address.setText(editItem.getAddress());
        nickName.setText(editItem.getNickName());
    }

    public boolean check() {
        if ("".equals(id.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "id cannot be empty");
            return false;
        }
        if ("".equals(fullName.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Name cannot be empty");
            return false;
        }
        if ("".equals(contactNumber.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "contactNumber has wrong format");
            return false;
        }
        if ("".equals(address.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Address cannot be empty");
            return false;
        }
        if ("".equals(nickName.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Nickname has wrong format");
            return false;
        }
        return true;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        address = new javax.swing.JTextField();
        nickName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fullName = new javax.swing.JTextField();
        contactNumber = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NewAuthor");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("address");

        jLabel2.setText("nickName");

        jLabel3.setText("fullName");

        jLabel4.setText("contactNumber");

        jLabel5.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addComponent(fullName)
                    .addComponent(id)
                    .addComponent(contactNumber)
                    .addComponent(address)
                    .addComponent(nickName))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addComponent(jButton1)
                .addContainerGap())
        );

        fullName.getAccessibleContext().setAccessibleName("");
        fullName.getAccessibleContext().setAccessibleDescription("");

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
                statement.executeUpdate("insert into User1 "
                        + "(id,full_name,contact_number,address,nickname) values ('" 
                        + id.getText() + "','" + fullName.getText() + "','" 
                        + contactNumber.getText() + "','" + address.getText() 
                        + "','" + nickName.getText() + "');");
            } else {
                statement.executeUpdate("update User1 set id='" + id.getText() 
                        + "',full_name='" + fullName.getText() 
                        + "',contact_number='" + contactNumber.getText() 
                        + "',address='" + address.getText() + "',nickname='" 
                        + nickName.getText() + "' where ID=" + editItem.getId()
                        + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JTextField fullName;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nickName;
    // End of variables declaration//GEN-END:variables
}
