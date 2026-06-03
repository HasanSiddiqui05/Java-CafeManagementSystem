package rms;

import dbconnect.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class food extends javax.swing.JFrame {
    Connection sos = null;
    PreparedStatement sss = null;
    ResultSet rs = null;
    public food() {
         initComponents();
         sos = dbconnect.connect();
         table();
    }
    public void table()
        {
            try 
            {
                String sql = "SELECT fname AS Name,ftype AS Type ,fprice AS Price, fid AS ID FROM foods ";
                sss = sos.prepareStatement(sql);
                rs = sss.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) 
            {
            }
     }
        public void tabledata()
        {
            int r = jTable1.getSelectedRow();
            
            String name = jTable1.getValueAt(r,0).toString();
            String price = jTable1.getValueAt(r,2).toString();
            String id = jTable1.getValueAt(r,3).toString(); 
            
            namebox.setText(name);
            pricebox.setText(price);
            idbox.setText(id);
            
        }
        public void search()
        {
            String sea = searchbox.getText();
            try 
            {
             String sql = "SELECT * FROM foods WHERE fname LIKE '%"+sea+"%'OR fid LIKE '%"+sea+"%'";  
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
            String type = jComboBox1.getSelectedItem().toString();
            String price = pricebox.getText();
            String id = idbox.getText();
            try 
            {
                String sql = "UPDATE foods SET fname = '"+name+"',ftype ='"+type+"',fprice ='"+price+"',fid = '"+id+"' WHERE fid = '"+id+"'";
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

        jPanel3 = new javax.swing.JPanel();
        clearbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        insertbutton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pricebox = new javax.swing.JTextField();
        sgdhd = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Food Menu");

        jPanel3.setLayout(null);

        clearbutton.setForeground(new java.awt.Color(153, 0, 153));
        clearbutton.setText("CLEAR");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(clearbutton);
        clearbutton.setBounds(840, 10, 90, 30);

        deletebutton.setForeground(new java.awt.Color(153, 0, 153));
        deletebutton.setText("DELETE");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        jPanel3.add(deletebutton);
        deletebutton.setBounds(740, 10, 90, 30);

        updatebutton.setForeground(new java.awt.Color(153, 0, 153));
        updatebutton.setText("UPDATE");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });
        jPanel3.add(updatebutton);
        updatebutton.setBounds(640, 10, 90, 30);

        insertbutton.setForeground(new java.awt.Color(153, 0, 153));
        insertbutton.setText("INSERT");
        insertbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(insertbutton);
        insertbutton.setBounds(540, 10, 90, 30);

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(20, 480, 90, 30);

        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(410, 480, 90, 30);

        jLabel6.setText("Search");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(950, 20, 50, 13);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "              ID", "            Name", "            Type", "            Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
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

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(540, 220, 560, 270);

        searchbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel3.add(searchbox);
        searchbox.setBounds(1000, 10, 140, 30);

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 153));
        jLabel7.setText("ORDER FOOD");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(150, 20, 300, 40);
        jPanel3.add(idbox);
        idbox.setBounds(480, 10, 40, 20);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Type");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 65, 50, -1));

        namebox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });
        jPanel1.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 11, 220, 28));

        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Food Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 17, 68, -1));

        pricebox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(pricebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 103, 220, 28));

        sgdhd.setForeground(new java.awt.Color(0, 0, 102));
        sgdhd.setText("Food Price");
        jPanel1.add(sgdhd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 109, 70, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Full" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 60, -1, -1));

        jPanel3.add(jPanel1);
        jPanel1.setBounds(540, 50, 560, 150);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/foodim.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, -10, 1150, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        update();
        table();
    }//GEN-LAST:event_updatebuttonActionPerformed
    private void insertbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbuttonActionPerformed
       String name;
       String type;
       int price;       
       name = namebox.getText();
       type = jComboBox1.getSelectedItem().toString();
       price = Integer.parseInt(pricebox.getText());
        try 
        {
            String sen = "INSERT INTO foods (fname ,ftype ,fprice ) VALUES ('"+name+"','"+type+"','"+price+"')";
            sss = sos.prepareStatement(sen);
            sss.execute();
            JOptionPane.showMessageDialog(null,"Succesful");
            
        } catch (Exception e) 
        {
          JOptionPane.showMessageDialog(null,e);
        }
        table();                                  
    }//GEN-LAST:event_insertbuttonActionPerformed
         public void clear()
    {
     searchbox.setText("");
     namebox.setText ("");
     pricebox.setText("");
     idbox.setText("");
    }
    public void tables()
    {
        int r = jTable1.getSelectedRow();
        String name = jTable1.getValueAt(r,0).toString();
        String price = jTable1.getValueAt(r,2).toString();
        String id = jTable1.getValueAt(r,3).toString(); 
        namebox.setText(name);
        pricebox.setText(price);
        idbox.setText(id);
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tables();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        tables();
    }//GEN-LAST:event_jTable1KeyReleased

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        clear();
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased
    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        int check = JOptionPane.showConfirmDialog(null,"Do you want to delete?");
        if (check == 0)
        {
            String name = namebox.getText();
            try
            {
                String sql = "DELETE FROM foods WHERE fname = '"+name+"'";
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        {
            afterlog sy = new afterlog ();
            sy.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            int check =JOptionPane.showConfirmDialog(null,"Do you want to exit","Warning",JOptionPane.YES_NO_OPTION);
        if (check == 0)
        {System.exit(0);
        }     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new food().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton deletebutton;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField pricebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JLabel sgdhd;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
