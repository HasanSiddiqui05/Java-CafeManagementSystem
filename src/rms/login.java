package rms;

import dbconnect.dbconnect;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class login extends javax.swing.JFrame {    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public login() {
        initComponents();
        con = dbconnect.connect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        pword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        labal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loging");

        jPanel3.setLayout(null);

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create a new account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(80, 350, 250, 40);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(380, 50, 450, 50);

        uname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uname.setBorder(null);
        jPanel3.add(uname);
        uname.setBounds(120, 170, 230, 40);

        pword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pword.setBorder(null);
        jPanel3.add(pword);
        pword.setBounds(120, 220, 230, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(150, 310, 100, 30);

        labal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login.png"))); // NOI18N
        labal.setText("jLabel4");
        jPanel3.add(labal);
        labal.setBounds(0, 0, 823, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {           
            String sql = "SELECT * FROM regis WHERE ruser='" + uname.getText() + "' AND rpass= '" + pword.getText() + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                afterlog ne = new afterlog();
                ne.setVisible(true);
                setVisible(false);
                }
            else
                {
                 JOptionPane.showMessageDialog(null,"Username or Password is incorrect");
                 uname.setText("");
                 pword.setText("");
                }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registerform mm = new registerform();
        mm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labal;
    private javax.swing.JPasswordField pword;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
