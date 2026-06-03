package rms;

import dbconnect.dbconnect;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class bill extends javax.swing.JFrame {    
    double num,ans;
    int calculation;
    Connection sos = null;
    PreparedStatement sss = null;
    ResultSet rs = null;
    String sqr;
    Double totalAmount=0.0;
    Double cash=0.0;
    Double balance=0.0;
    Double bHeight=0.0;
    ArrayList<String> itemName = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> itemPrice = new ArrayList<>();
    ArrayList<String> subtotal = new ArrayList<>();
    String iname;
    String itype;
    int iquantity;
    Double iprice;
    Double iamount;
    Double ibillno;
    public bill() {
        initComponents();
        sos = dbconnect.connect();
        tablenew();
    }
    public void equal()            
    {
        switch (calculation)
        {
            case 1 :
                ans = num + Double.parseDouble(screen.getText());
                screen.setText(Double.toString(ans));
                break;       
            case 2 :
                ans = num - Double.parseDouble(screen.getText());
                screen.setText(Double.toString(ans));
                break;   
            case 3 :
                ans = num / Double.parseDouble(screen.getText());
                screen.setText(Double.toString(ans));
                break;   
            case 4 :
                ans = num * Double.parseDouble(screen.getText());
                screen.setText(Double.toString(ans));
                break;     
        }
    }
    public void tablenew()
    {
        try 
        {
            String sql = "SELECT fname AS Name,ftype AS Type ,fprice AS Price,fid AS Id FROM foods ";
            sss = sos.prepareStatement(sql);
            rs = sss.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
        }
    }
    public void tabledata()
    {
        int r = jTable1.getSelectedRow();
        String name = jTable1.getValueAt(r,0).toString();
        String type = jTable1.getValueAt(r,1).toString();
        String price = jTable1.getValueAt(r,2).toString();
        String id = jTable1.getValueAt(r,3).toString();
        namebox.setText(name);
        typebox.setText(type);
        pricebox.setText(price);
    }
    public void search()
    {
        String nnn = searchbox.getText();
        try 
        {
         String sql = "SELECT * FROM foods WHERE fname LIKE '%"+nnn+"%'OR fid LIKE '%"+nnn+"%'";  
         sss = sos.prepareStatement(sql);
         rs = sss.executeQuery();
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e) 
        {
        JOptionPane.showMessageDialog(null,"Error");
        }
    }           
    public void clear()
    {
        searchbox.setText("");
        namebox.setText ("");
        typebox.setText("");
        pricebox.setText("");
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        Type = new javax.swing.JLabel();
        typebox = new javax.swing.JTextField();
        Price = new javax.swing.JLabel();
        pricebox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        endprice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        balancebox = new javax.swing.JTextField();
        cashbox = new javax.swing.JTextField();
        totalamountbox = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        six = new javax.swing.JButton();
        five = new javax.swing.JButton();
        three = new javax.swing.JButton();
        two = new javax.swing.JButton();
        one = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        dot = new javax.swing.JButton();
        divide = new javax.swing.JButton();
        multi = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        add = new javax.swing.JButton();
        equals = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        four = new javax.swing.JButton();
        screen = new javax.swing.JTextField();
        remain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Printing Bill");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(null);

        jButton4.setText("EXIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(370, 470, 80, 40);

        jButton5.setBackground(new java.awt.Color(51, 0, 51));
        jButton5.setText("BACK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);
        jButton5.setBounds(70, 470, 80, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Price", "ID"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(70, 130, 390, 300);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Search");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(230, 80, 60, 30);

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
        jPanel4.add(searchbox);
        searchbox.setBounds(290, 80, 180, 30);

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 204));
        jLabel2.setText("Print Bill");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(170, 10, 180, 40);

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(510, 10, 130, 40);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 48, -1, -1));
        jPanel3.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 44, 180, -1));

        Type.setForeground(new java.awt.Color(0, 0, 0));
        Type.setText("Type");
        jPanel3.add(Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 80, -1, 12));
        jPanel3.add(typebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 74, 180, -1));

        Price.setForeground(new java.awt.Color(0, 0, 0));
        Price.setText("Price of the item");
        jPanel3.add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 108, -1, -1));
        jPanel3.add(pricebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 104, 180, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Quantity");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 139, -1, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("End price");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 170, -1, -1));
        jPanel3.add(endprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 166, 180, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Total Amount ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 235, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cash");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 271, -1, -1));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("balance");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 307, -1, -1));
        jPanel3.add(balancebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 303, 162, -1));
        jPanel3.add(cashbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 267, 162, -1));
        jPanel3.add(totalamountbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 231, 162, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 134, 115, -1));

        jPanel4.add(jPanel3);
        jPanel3.setBounds(510, 60, 480, 370);

        jButton7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 0, 204));
        jButton7.setText("Print");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);
        jButton7.setBounds(590, 440, 340, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/otherim.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(0, 0, 1000, 530);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1002, 528));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel5.setForeground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Calculator");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        seven.setBackground(new java.awt.Color(255, 255, 255));
        seven.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        seven.setText("7");
        seven.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenActionPerformed(evt);
            }
        });
        jPanel5.add(seven, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 30));

        eight.setBackground(new java.awt.Color(255, 255, 255));
        eight.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        eight.setText("8");
        eight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightActionPerformed(evt);
            }
        });
        jPanel5.add(eight, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 50, 30));

        nine.setBackground(new java.awt.Color(255, 255, 255));
        nine.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        nine.setText("9");
        nine.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineActionPerformed(evt);
            }
        });
        jPanel5.add(nine, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 50, 30));

        six.setBackground(new java.awt.Color(255, 255, 255));
        six.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        six.setText("6");
        six.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixActionPerformed(evt);
            }
        });
        jPanel5.add(six, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 50, 30));

        five.setBackground(new java.awt.Color(255, 255, 255));
        five.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        five.setText("5");
        five.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });
        jPanel5.add(five, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 50, 30));

        three.setBackground(new java.awt.Color(255, 255, 255));
        three.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        three.setText("3");
        three.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });
        jPanel5.add(three, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 50, 30));

        two.setBackground(new java.awt.Color(255, 255, 255));
        two.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        two.setText("2");
        two.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoActionPerformed(evt);
            }
        });
        jPanel5.add(two, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 50, 30));

        one.setBackground(new java.awt.Color(255, 255, 255));
        one.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        one.setText("1");
        one.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneActionPerformed(evt);
            }
        });
        jPanel5.add(one, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));

        zero.setBackground(new java.awt.Color(255, 255, 255));
        zero.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        zero.setText("0");
        zero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        jPanel5.add(zero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 50, 30));

        dot.setBackground(new java.awt.Color(255, 255, 255));
        dot.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        dot.setText(".");
        dot.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        dot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dotActionPerformed(evt);
            }
        });
        jPanel5.add(dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 50, 30));

        divide.setBackground(new java.awt.Color(255, 255, 255));
        divide.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        divide.setText("/");
        divide.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divideActionPerformed(evt);
            }
        });
        jPanel5.add(divide, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 50, 30));

        multi.setBackground(new java.awt.Color(255, 255, 255));
        multi.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        multi.setText("*");
        multi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        multi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiActionPerformed(evt);
            }
        });
        jPanel5.add(multi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 50, 30));

        minus.setBackground(new java.awt.Color(255, 255, 255));
        minus.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        minus.setText("-");
        minus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });
        jPanel5.add(minus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 50, 30));

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        add.setText("+");
        add.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel5.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 110, 30));

        equals.setBackground(new java.awt.Color(255, 255, 255));
        equals.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        equals.setText("=");
        equals.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsActionPerformed(evt);
            }
        });
        jPanel5.add(equals, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 170, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        jButton1.setText("Clear");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, 20));

        four.setBackground(new java.awt.Color(255, 255, 255));
        four.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        four.setText("4");
        four.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });
        jPanel5.add(four, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 50, 30));

        screen.setEditable(false);
        screen.setBackground(new java.awt.Color(0, 0, 0));
        screen.setFont(new java.awt.Font("Tw Cen MT", 3, 14)); // NOI18N
        screen.setForeground(new java.awt.Color(255, 255, 255));
        screen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        screen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        screen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenActionPerformed(evt);
            }
        });
        jPanel5.add(screen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 30));

        remain.setFont(new java.awt.Font("Tw Cen MT", 3, 12)); // NOI18N
        remain.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(remain, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 50, 10));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 327));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1008, 6, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            tabledata();
    }//GEN-LAST:event_jTable1MouseClicked
    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
     
    }//GEN-LAST:event_jTable1KeyReleased
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clear();
    }//GEN-LAST:event_jButton3ActionPerformed
    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int check = JOptionPane.showConfirmDialog(null,"Do you want to exit","Warning",JOptionPane.YES_NO_OPTION);
        if (check == 0)
        {System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        
    }//GEN-LAST:event_jTable1KeyPressed
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        iname = namebox.getText();
        iquantity = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        iprice = Double.valueOf(pricebox.getText());
        iamount = Double.valueOf(endprice.getText());
        totalAmount = totalAmount+ Double.valueOf(totalamountbox.getText());
        totalamountbox.setText(totalAmount+"");
        try {
            String qr= "INSERT INTO `sale`(`item_name`, `quantity`, `item_price`, `amount`) VALUES ('"+iname+"','"+iquantity+"','"+iprice+"','"+iamount+"')";
             sss = sos.prepareStatement(qr);
             sss.execute(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }                                                                 
        getData();
        getBillData();
        try {
            jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(bill.class.getName()).log(Level.SEVERE, null, ex);
        }
        bHeight = Double.valueOf(itemName.size());
        JOptionPane.showMessageDialog(rootPane, bHeight);
        
       String name;
       String type;
       int price;
       int quantitys;
       int endprices;
       double totalamount;
       int cashs;
       int balances;
       name = namebox.getText();
       type = typebox.getText();
       price = Integer.parseInt(pricebox.getText());
       quantitys = Integer.parseInt(jComboBox1.getSelectedItem().toString());
       endprices = Integer.parseInt(endprice.getText());
       totalamount = Double.valueOf(totalamountbox.getText());
       cashs = Integer.parseInt(cashbox.getText());
       balances = Integer.parseInt(balancebox.getText());
//       SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        try 
        {
            String sen = "INSERT INTO allsale (sname ,stype ,sprice,squantity,sendprice,stotalamou,scashs,sbalances) VALUES ('"+name+"','"+type+"','"+price+"','"+quantitys+"','"+endprices+"','"+totalamount+"','"+cashs+"','"+balances+"')";
            sss = sos.prepareStatement(sen);
            sss.execute();
            JOptionPane.showMessageDialog(null,"Succesful");
            
        } catch (Exception e) 
        {
          JOptionPane.showMessageDialog(null,e);
        }                                
    }//GEN-LAST:event_jButton7ActionPerformed
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    {
        afterlog sy = new afterlog ();
        sy.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
        screen.setText(screen.getText()+ "7");;
    }//GEN-LAST:event_sevenActionPerformed
    private void eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
        screen.setText(screen.getText()+ "8");
    }//GEN-LAST:event_eightActionPerformed
    private void nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
        screen.setText(screen.getText()+ "9");
    }//GEN-LAST:event_nineActionPerformed
    private void sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
        screen.setText(screen.getText()+ "6");
    }//GEN-LAST:event_sixActionPerformed
    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
        screen.setText(screen.getText()+ "5");
    }//GEN-LAST:event_fiveActionPerformed
    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        screen.setText(screen.getText()+ "3");
    }//GEN-LAST:event_threeActionPerformed
    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
        screen.setText(screen.getText()+ "2");
    }//GEN-LAST:event_twoActionPerformed
    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
        screen.setText(screen.getText()+ "1");
    }//GEN-LAST:event_oneActionPerformed
    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
        screen.setText(screen.getText()+ "0");
    }//GEN-LAST:event_zeroActionPerformed
    private void dotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dotActionPerformed
        screen.setText(screen.getText()+ ".");
    }//GEN-LAST:event_dotActionPerformed
    private void equalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalsActionPerformed
        equal();
    }//GEN-LAST:event_equalsActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        screen.setText(" ");
        remain.setText(" ");
    }//GEN-LAST:event_jButton1ActionPerformed
    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
        screen.setText(screen.getText()+ "4");
    }//GEN-LAST:event_fourActionPerformed
    private void screenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenActionPerformed

    }//GEN-LAST:event_screenActionPerformed
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        num = Double.parseDouble(screen.getText());
        calculation = 1;
        screen.setText(" ");
        remain.setText(num+"+");
    }//GEN-LAST:event_addActionPerformed
    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed
        num = Double.parseDouble(screen.getText());
        calculation = 2;
        screen.setText(" ");
        remain.setText(num+"-");
    }//GEN-LAST:event_minusActionPerformed
    private void multiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiActionPerformed
        num = Double.parseDouble(screen.getText());
        calculation = 4;
        screen.setText(" ");
        remain.setText(num+"*");
    }//GEN-LAST:event_multiActionPerformed
    private void divideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divideActionPerformed
        num = Double.parseDouble(screen.getText());
        calculation = 3;
        screen.setText(" ");
        remain.setText(num+"/");
    }//GEN-LAST:event_divideActionPerformed
    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed
    private void getData()
    {
        try {
                String sql="SELECT `bill_no`, `item_name`,`quantity`, `item_price`, `amount` FROM `sale` WHERE bill_no='"+totalamountbox.getText()+"'";
                sss = sos.prepareStatement(sql);
                rs=sss.executeQuery();
             while(rs.next())
             {
                 itemName.add(rs.getString("item_name"));
                 quantity.add(rs.getString("quantity"));
                 itemPrice.add(rs.getString("item_price"));
                 subtotal.add(rs.getString("amount"));
                 
                }
        } catch (Exception e) {
        }
    }
    private void getBillData()
    {
        try {
                String sql="SELECT `bill_no`, `total_amount`, `cash`, `balance` FROM `cash` WHERE bill_no='"+totalamountbox.getText()+"'";
                sss = sos.prepareStatement(sql);
                 rs= sss.executeQuery();
            while(rs.next())
            {
                totalAmount = rs.getDouble("total_amount");
                cash = rs.getDouble("cash");     
                 balance = rs.getDouble("balance");
            }
        } catch (Exception e) {
        }
    }
        
   

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Type;
    private javax.swing.JButton add;
    private javax.swing.JTextField balancebox;
    private javax.swing.JTextField cashbox;
    private javax.swing.JButton divide;
    private javax.swing.JButton dot;
    private javax.swing.JButton eight;
    private javax.swing.JTextField endprice;
    private javax.swing.JButton equals;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton minus;
    private javax.swing.JButton multi;
    private javax.swing.JTextField namebox;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JTextField pricebox;
    private javax.swing.JLabel remain;
    private javax.swing.JTextField screen;
    private javax.swing.JTextField searchbox;
    private javax.swing.JButton seven;
    private javax.swing.JButton six;
    private javax.swing.JButton three;
    private javax.swing.JTextField totalamountbox;
    private javax.swing.JButton two;
    private javax.swing.JTextField typebox;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}
