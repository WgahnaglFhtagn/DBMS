package vasin.Entities.Section;

import Entities.Section;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewSection extends javax.swing.JDialog {

    Connection c;
    Section editItem;

    public NewSection(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        this.c = c;

        ((AbstractDocument) name.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) description.getDocument()).setDocumentFilter(new JTextFieldLimit(15));
    }

    public NewSection(java.awt.Frame parent, boolean modal, Connection c, Section u) {
        super(parent, modal);
        initComponents();
        this.c = c;
        editItem = u;

        ((AbstractDocument) name.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) description.getDocument()).setDocumentFilter(new JTextFieldLimit(15));
        fillFields();
    }

    private void fillFields() {
        name.setText(editItem.getName());
        description.setText(editItem.getDescription());
    }

    public boolean check() {
        if ("".equals(name.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Name cannot be empty");
            return false;
        }
        if ("".equals(description.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Description has wrong format");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        description = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NewSection");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("name");

        jLabel4.setText("description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(description)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        name.getAccessibleContext().setAccessibleName("");
        name.getAccessibleContext().setAccessibleDescription("");

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
                statement.executeUpdate("insert into Section (Name,Description) values ('" 
                        + name.getText() + "','" + description.getText() + "');");
            } else {
                statement.executeUpdate("update Section set Name='" 
                        + name.getText() + "',Description='" + description.getText() 
                        + "' where ID=" + editItem.getId() + ";");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField description;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
