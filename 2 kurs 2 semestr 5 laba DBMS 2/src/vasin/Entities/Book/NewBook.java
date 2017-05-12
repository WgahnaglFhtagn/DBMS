
package vasin.Entities.Book;

import Entities.Section;
import Entities.Author;
import Entities.Book;
import Entities.User;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import vasin.Entities.Author.AuthorsModel;
import vasin.Entities.Section.SectionsModel;
import vasin.Entities.User.UsersModel;

public class NewBook extends javax.swing.JDialog {

    Connection c;
    Book editItem;
    List<Section> list;
    List<Author> list1;
    List<User> list2;

    public NewBook(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        ((AbstractDocument) name.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        ((AbstractDocument) description.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        ((AbstractDocument) cost_price.getDocument()).setDocumentFilter(new JTextFieldLimit(10));
        this.c = c;
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        sectionid.setModel(new DefaultComboBoxModel(SectionsModel.selectSection(c).toArray()));
        authorid.setModel(new DefaultComboBoxModel(AuthorsModel.selectAuthor(c).toArray()));
        userid.setModel(new DefaultComboBoxModel(UsersModel.selectUser(c).toArray()));
    }

    public NewBook(java.awt.Frame parent, boolean modal, Connection c, Book b) throws SQLException {
        this(parent, modal, c);
        this.editItem = b;
        fillFields();
    }

    public NewBook() {
        
    }

    private void fillFields() {
        name.setText(editItem.getName());
        description.setText(editItem.getDescription());
        cost_price.setText(String.valueOf(editItem.getCostPrice()));
        for (Section s : list) {
            if (s.getId() == editItem.getSectionId()) {
                sectionid.setSelectedItem((s));
            }
        }
        for (Author s : list1) {
            if (s.getId() == editItem.getAuthorId()) {
                authorid.setSelectedItem((s));
            }
        }
        for (User s : list2) {
            if (s.getId() == editItem.getUserId()) {
                userid.setSelectedItem((s));
            }
        }
    }

    public boolean check() {
        if ("".equals(description.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Name cannot be empty");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        description = new javax.swing.JTextField();
        sectionid = new javax.swing.JComboBox<>();
        authorid = new javax.swing.JComboBox<>();
        userid = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cost_price = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New book");

        sectionid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionidActionPerformed(evt);
            }
        });

        userid.setToolTipText("");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("name");

        jLabel3.setText("section");

        jLabel4.setText("author");

        jLabel5.setText("user");

        jLabel6.setText("description");

        jLabel7.setText("cost_price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sectionid, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addComponent(cost_price))
                            .addComponent(authorid, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cost_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sectionidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionidActionPerformed

    }//GEN-LAST:event_sectionidActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!check()) {
            return;
        }
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into book (sectionid, name, "
                        + "description, cost_price, authorid, userid) values ('" 
                        + ((Section) sectionid.getSelectedItem()).getId() + "','" 
                        + name.getText() + "','" + description.getText() + "','" 
                        + cost_price.getText() + "','" 
                        + ((Author) authorid.getSelectedItem()).getId() + "','" 
                        + ((User) userid.getSelectedItem()).getId() + "');");
            } else {
                statement.executeUpdate("update book set sectionid='" 
                        + ((Section) sectionid.getSelectedItem()).getId() 
                        + "',name='" + name.getText() + "',description='" 
                        + description.getText() + "',cost_price='" 
                        + cost_price.getText() + "',authorid='" 
                        + ((Author) authorid.getSelectedItem()).getId() 
                        + "',userid='" + ((User) userid.getSelectedItem()).getId() 
                        + "' where id=" + editItem.getId() + ";");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> authorid;
    private javax.swing.JTextField cost_price;
    private javax.swing.JTextField description;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> sectionid;
    private javax.swing.JComboBox<String> userid;
    // End of variables declaration//GEN-END:variables
}
