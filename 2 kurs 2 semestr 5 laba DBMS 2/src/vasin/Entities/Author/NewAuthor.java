package vasin.Entities.Author;

import Entities.Author;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewAuthor extends javax.swing.JDialog {

    Connection c;
    Author editItem;

    public NewAuthor(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        this.c = c;

        ((AbstractDocument) fullName.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) contactNumber.getDocument()).setDocumentFilter(new JTextFieldLimit(15));
        ((AbstractDocument) address.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) numberOfWorks.getDocument()).setDocumentFilter(new JTextFieldLimit(10));
    }

    public NewAuthor(java.awt.Frame parent, boolean modal, Connection c, Author u) {
        super(parent, modal);
        initComponents();
        this.c = c;
        editItem = u;

        ((AbstractDocument) fullName.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) contactNumber.getDocument()).setDocumentFilter(new JTextFieldLimit(15));
        ((AbstractDocument) address.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) numberOfWorks.getDocument()).setDocumentFilter(new JTextFieldLimit(10));
        fillFields();
    }

    private void fillFields() {
        fullName.setText(editItem.getFullName());
        contactNumber.setText(String.valueOf(editItem.getContactNumber()));
        address.setText(editItem.getAddress());
        numberOfWorks.setText(String.valueOf(editItem.getNumberOfWorks()));
    }

    public boolean check() {
        if ("".equals(fullName.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Full_name cannot be empty");
            return false;
        }
        if ("".equals(contactNumber.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Contact_number has wrong format");
            return false;
        }
        if ("".equals(address.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Address cannot be empty");
            return false;
        }
        if ("".equals(numberOfWorks.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Number_of_works has wrong format");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        address = new javax.swing.JTextField();
        numberOfWorks = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fullName = new javax.swing.JTextField();
        contactNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NewAuthor");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        numberOfWorks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfWorksActionPerformed(evt);
            }
        });

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("address");

        jLabel2.setText("numberOfWorks");

        jLabel3.setText("fullName");

        jLabel4.setText("contactNumber");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numberOfWorks, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(contactNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fullName, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfWorks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                statement.executeUpdate("insert into author "
                        + "(full_name,contact_number,address,number_of_works) "
                        + "values ('" 
                        + fullName.getText() + "'," + contactNumber.getText() 
                        + ",'" + address.getText() + "'," 
                        + numberOfWorks.getText() + ");");
            } else {
                statement.executeUpdate("update author set Full_name='"
                        + fullName.getText() + "',Contact_number=" 
                        + contactNumber.getText() + 
                        ",Address='" + address.getText() + "',Number_of_works=" 
                        + numberOfWorks.getText() + " where ID=" 
                        + editItem.getId() + ";");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void numberOfWorksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfWorksActionPerformed

    }//GEN-LAST:event_numberOfWorksActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JTextField fullName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField numberOfWorks;
    // End of variables declaration//GEN-END:variables
}
