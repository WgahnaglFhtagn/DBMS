package vasinMain;

import java.awt.HeadlessException;
import vasin.Entities.Author.Authors;
import vasin.Entities.Book.Books;
import vasin.Entities.Section.Sections;
import vasin.Entities.Order.Orders;
import vasin.Entities.User.Users;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vasin.Entities.Book.NewBook;
import vasin.Entities.Order.NewOrder;

public class vasinMain extends javax.swing.JFrame {

    Connection connection = null;

    public vasinMain() {
        initComponents();
        NewConnect nc = new NewConnect(this, true);
        nc.setVisible(true);
        if (nc.ready) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                status.setText("Connecting to database: " 
                        + url.substring(url.lastIndexOf("/") + 1));
            } else {
                status.setText("No connection");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Author = new javax.swing.JMenuItem();
        Book = new javax.swing.JMenuItem();
        Order = new javax.swing.JMenuItem();
        Section = new javax.swing.JMenuItem();
        User = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InternetBookStore");

        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenu1.setText("NewConnection");

        jMenuItem3.setText("NewConnection");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("CloseConnection");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("CloseProgram");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Entities");

        Author.setText("Author");
        Author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorActionPerformed(evt);
            }
        });
        jMenu2.add(Author);

        Book.setText("Book");
        Book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookActionPerformed(evt);
            }
        });
        jMenu2.add(Book);

        Order.setText("Order");
        Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderActionPerformed(evt);
            }
        });
        jMenu2.add(Order);

        Section.setText("Section");
        Section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SectionActionPerformed(evt);
            }
        });
        jMenu2.add(Section);

        User.setText("User");
        User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserActionPerformed(evt);
            }
        });
        jMenu2.add(User);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Actions");

        jMenuItem9.setText("Make order");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Put a book");
        jMenuItem10.setActionCommand("");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 295, Short.MAX_VALUE)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        NewConnect nc = new NewConnect(this, true);
        nc.setVisible(true);
        if (nc.ready) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                status.setText("Connecting to database: " 
                        + url.substring(url.lastIndexOf("/") + 1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {
            connection.close();
            JOptionPane.showMessageDialog(new JFrame(), "Connection is closed.");
            connection = null;
            status.setText("No connection");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void AuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorActionPerformed

        if (connection != null) {
            try {
                Authors a = new Authors(this, true, connection);
                a.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(vasinMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_AuthorActionPerformed

    private void BookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookActionPerformed

        if (connection != null) {
            Books b = new Books(this, true, connection);
            b.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_BookActionPerformed

    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed

        if (connection != null) {
            try {
                Users u = new Users(this, true, connection);
                u.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(vasinMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_UserActionPerformed

    private void OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderActionPerformed

        if (connection != null) {
            try {
                Orders o = new Orders(this, true, connection);
                o.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(vasinMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_OrderActionPerformed

    private void SectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SectionActionPerformed

        if (connection != null) {
            Sections s = new Sections(this, true, connection);
            s.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_SectionActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        if (connection != null) {
            NewOrder no = new NewOrder(this, true, connection);
            no.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        try
        {
        if (connection != null) {
            NewBook nb = new NewBook(this, true, connection);
            nb.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
        } catch (HeadlessException | SQLException e)
        {}
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException 
                | IllegalAccessException 
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vasinMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new vasinMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Author;
    private javax.swing.JMenuItem Book;
    private javax.swing.JMenuItem Order;
    private javax.swing.JMenuItem Section;
    private javax.swing.JMenuItem User;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
