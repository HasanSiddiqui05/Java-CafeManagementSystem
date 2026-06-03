package rms;

import dbconnect.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class staff extends javax.swing.JFrame {
    Connection sos = null;
    PreparedStatement sss = null;
    ResultSet rs = null;
    public staff() {
        initComponents();
        sos = dbconnect.connect();
        table();
    }
    public void table()
    {
        try 
        {
            String sql = "SELECT rname AS Name,rposition AS Position,rphone AS Phone,rsection AS Section,rid AS ID,raddress AS Address,rage AS Age,rnic AS NIC FROM roles ";
            sss = sos.prepareStatement(sql);
            rs = sss.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
        }
    }
    public void search()
    {
        String nnn = searchbox.getText();
        try 
        {
         String sql = "SELECT * FROM roles WHERE rname LIKE '%"+nnn+"%'OR rid LIKE '%"+nnn+"%'";  
         sss = sos.prepareStatement(sql);
         rs = sss.executeQuery();
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e) 
        {
        JOptionPane.showMessageDialog(null,"Error");
        }
    }   
    public void update ()
    {
      String name = namebox.getText();
      String position = positionbox.getText();
      String phone = phonebox.getText();
      String section = sectionbox.getText();
      String id = idbox.getText();
      String address = addressbox.getText();
      String age = agebox.getText();
      String idnumber = idnbox.getText();     
    {
        }
        try 
            {
                String sql = "UPDATE roles SET rname = '"+name+"',rposition ='"+position+"',rphone ='"+phone+"',rsection ='"+section+"',raddress ='"+address+"',rage ='"+age+"',rnic ='"+idnumber+"' WHERE rid = '"+id+"' ";
                sss = sos.prepareStatement(sql);
                sss.execute();
                JOptionPane.showMessageDialog(null,"Updated");
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        clearbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        insertbutton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        idbox = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        positionbox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        phonebox = new javax.swing.JTextField();
        sectionbox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        addressbox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        agebox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        idnbox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stuff Details");
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.darkGray));
        jPanel2.setLayout(null);

        jButton1.setForeground(new java.awt.Color(255, 0, 204));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 430, 80, 40);

        exitbutton.setForeground(new java.awt.Color(255, 0, 204));
        exitbutton.setText("Exit");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(exitbutton);
        exitbutton.setBounds(290, 430, 80, 40);

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 204));
        jLabel7.setText("Staff");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(150, 20, 100, 41);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "            Name", "         Position", "     Phone Number", "      Section", "      ID"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(390, 90, 630, 370);

        clearbutton.setForeground(new java.awt.Color(255, 0, 204));
        clearbutton.setText("CLEAR");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(clearbutton);
        clearbutton.setBounds(610, 10, 90, 40);

        deletebutton.setForeground(new java.awt.Color(255, 0, 204));
        deletebutton.setText("DELETE");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        jPanel2.add(deletebutton);
        deletebutton.setBounds(510, 10, 90, 40);

        updatebutton.setForeground(new java.awt.Color(255, 0, 204));
        updatebutton.setText("UPDATE");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });
        jPanel2.add(updatebutton);
        updatebutton.setBounds(410, 10, 90, 40);

        insertbutton.setForeground(new java.awt.Color(255, 0, 204));
        insertbutton.setText("INSERT");
        insertbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(insertbutton);
        insertbutton.setBounds(310, 10, 90, 40);

        jLabel6.setText("Search");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(720, 30, 50, 13);

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel2.add(searchbox);
        searchbox.setBounds(770, 20, 220, 30);
        jPanel2.add(idbox);
        idbox.setBounds(0, 0, 0, 0);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(positionbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 89, 262, 28));

        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Phone Number");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, -1, -1));

        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });
        jPanel1.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 19, 266, 29));

        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Position");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 96, -1, 14));

        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Section");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 129, -1, -1));
        jPanel1.add(phonebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 54, 226, 29));
        jPanel1.add(sectionbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 123, 262, 28));

        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Address");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 163, -1, -1));
        jPanel1.add(addressbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 157, 262, 28));

        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Age");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 197, -1, -1));
        jPanel1.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 191, 262, 28));

        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("ID Number");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 231, -1, -1));
        jPanel1.add(idnbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 225, 262, 29));

        jPanel2.add(jPanel1);
        jPanel1.setBounds(20, 80, 350, 320);

        jLabel1.setForeground(new java.awt.Color(255, 0, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/otherim.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        {
            afterlog sy = new afterlog ();
            sy.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void clear()
    {
        searchbox.setText("");
        namebox.setText ("");
        phonebox.setText("");
        sectionbox.setText("");
        positionbox.setText("");
        idbox.setText("");
        addressbox.setText("");
        agebox.setText("");
        idnbox.setText("");
    }       
    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        clear();
    }//GEN-LAST:event_clearbuttonActionPerformed
    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed
    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        int check = JOptionPane.showConfirmDialog(null,"Do you want to delete?");        
        if (check == 0)
        {
          String name = namebox.getText();
            try 
            {
                String sql = "DELETE FROM roles WHERE rname = '"+name+"'"; 
                sss=sos.prepareCall(sql);
                sss.execute();
                JOptionPane.showMessageDialog(null,"Deleted");
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error");
            }          
        }
        table();                                      
    }//GEN-LAST:event_deletebuttonActionPerformed
    public void tables()
    {
        int r = jTable1.getSelectedRow();
        String name = jTable1.getValueAt(r,0).toString();
        String position = jTable1.getValueAt(r,1).toString();
        String phone = jTable1.getValueAt(r,2).toString();
        String section = jTable1.getValueAt(r,3).toString();
        String id = jTable1.getValueAt(r,4).toString();
        String address = jTable1.getValueAt(r,5).toString();
        String age = jTable1.getValueAt(r,6).toString();
        String idnumber = jTable1.getValueAt(r,7).toString();
        namebox.setText(name);
        positionbox.setText(position);
        phonebox.setText(phone);
        sectionbox.setText(section);
        idbox.setText(id);
        addressbox.setText(address);
        agebox.setText(age);
        idnbox.setText(idnumber);
    }   
    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased
    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        update();
        table();
    }//GEN-LAST:event_updatebuttonActionPerformed
    private void insertbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbuttonActionPerformed
       String name;
       String position;
       String phone;
       String section;
       String address;
       String age;
       String idnumber;
       name = namebox.getText();
       position = positionbox.getText();
       phone = phonebox.getText();
       section = sectionbox.getText();
       age = agebox.getText();
       address = addressbox.getText();
       idnumber = idnbox.getText();     
        try 
        {
            String sen = "INSERT INTO roles (rname ,rposition ,rphone ,rsection,raddress,rage,rnic) VALUES ('"+name+"','"+position+"','"+phone+"','"+section+"','"+address+"','"+age+"','"+idnumber+"')";
            sss = sos.prepareStatement(sen);
            sss.execute();
            JOptionPane.showMessageDialog(null,"Succesful");
            
        } catch (Exception e) 
        {
          JOptionPane.showMessageDialog(null,e);
        }
        table();                          
    }//GEN-LAST:event_insertbuttonActionPerformed
    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        tables();
    }//GEN-LAST:event_jTable1KeyReleased
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tables();
    }//GEN-LAST:event_jTable1MouseClicked
    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        int check =JOptionPane.showConfirmDialog(null,"Do you want to exit","Warning",JOptionPane.YES_NO_OPTION);
        if (check == 0)
        {System.exit(0);
        }
    }//GEN-LAST:event_exitbuttonActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressbox;
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton deletebutton;
    private javax.swing.JButton exitbutton;
    private javax.swing.JLabel idbox;
    private javax.swing.JTextField idnbox;
    private javax.swing.JButton insertbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField phonebox;
    private javax.swing.JTextField positionbox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField sectionbox;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
