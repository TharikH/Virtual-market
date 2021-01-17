/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import virtual.market.DbConnect;

/**
 *
 * @author kite
 */
public class cart1 extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form cart1
     */
     String id="1", type;
     
    private ImageIcon format = null;
    String fname = null;
    int s = 0;
    byte[] pimage = null;
    
    public cart1() {
        initComponents();
    }
    
    public cart1(String id, String type) {
        this();
        this.id = id;
        this.type = type;
        fetchData();

    }

        private void render(ResultSet rs) throws SQLException {
        ArrayList arr = new ArrayList<JPanel>();
        JPanel but;
        String stock_id, product_name;
        int num;
        float rate;
        int sum=0;
//        Border blackline = BorderFactory.createEmptyBorder(50,50, 50, 50);
        while (rs.next()) {
            rate = rs.getFloat("sell_rate");
            num = rs.getInt("no.s");
            stock_id = rs.getString("stock_id");
            product_name = rs.getString("product_name");
            byte[] imagedata = rs.getBytes("img");
            format = new ImageIcon(imagedata);
            Image mm = format.getImage();
            
            JButton desc = new JButton("Description");
            JPanel jp = new JPanel();
            JLabel jl = new JLabel();
            JButton jb = new JButton("Buy now");
            JLabel jname = new JLabel(product_name.toUpperCase(), SwingConstants.CENTER);
            JButton cartbut = new JButton("Remove ");
            float total = num*rate;
            sum+=total;
            JLabel jrate = new JLabel(String.valueOf(rate) + "Rs/- X " +String.valueOf(num) + "=" + String.valueOf(total) , SwingConstants.CENTER);
            jl.setPreferredSize(new Dimension(250, 180));
            jb.setPreferredSize(new Dimension(100, 50));
            cartbut.setPreferredSize(new Dimension(100, 50));
            jname.setPreferredSize(new Dimension(200, 30));
            jrate.setPreferredSize(new Dimension(200, 30));
          
            desc.setPreferredSize(new Dimension(200, 30));

            jrate.setFont(new Font("Serif", Font.BOLD, 17));
            jname.setFont(new Font("Serif", Font.BOLD, 17));
            
            
            Image img2 = mm.getScaledInstance(250, 180, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(img2);
            jl.setIcon(image);
            jl.setHorizontalAlignment(SwingConstants.CENTER);
            jl.setVerticalAlignment(SwingConstants.CENTER);

            jb.setActionCommand("buy-" + stock_id+"-"+id+"-"+String.valueOf(num)+"-"+String.valueOf(total));
            cartbut.setActionCommand("remo-" + stock_id+"-"+id);
            desc.setActionCommand("desc-" + stock_id+"-"+id);
//            jl.setBackground(Color.red);
//            jb.setBackground(Color.blue);
//            jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
            jb.addActionListener(this);
            cartbut.addActionListener(this);
            desc.addActionListener(this);

            jb.setCursor(new Cursor(12));
            cartbut.setCursor(new Cursor(12));
            desc.setCursor(new Cursor(12));

            jp.add(jl);
            jp.add(jname);
            jp.add(jrate);
            jp.add(cartbut);
            jp.add(jb);
            jp.add(desc);
//            jp.setBorder(blackline);
            jp.setBackground(new Color(40, 116, 240));
            arr.add(jp);
        }
        
        jLabel3.setText(String.valueOf(sum));

        int i = 30, k = 0, j, m;
        int n = arr.size();
        JPanel temp;
        while (k < n) {
            j = 0;
            m = 10;
            while (j < 3) {
                if (k < n) {
                    temp = (JPanel) arr.get(k);
                    temp.setBounds(m, i, 250, 350);
                    displaypanel.add(temp);
                    m += 275;
                    k++;
                }
                j++;
            }
            i += 365;
        }
//        for(Object j:arr){
//            but=(JPanel)j;
//            but.setBounds(10,i,805,200);
////            but.setBorder(blackline);
//            i+=215;
//            displaypanel.add(but);
//        }
        displaypanel.setPreferredSize(new Dimension(805, i));
    }
      private boolean checkStock(String stock_id) {
        int avail=0;
        try {
            
            Connection conn = new DbConnect().connect();
            String sql = "select availability from stock where stock_id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,stock_id);
            ResultSet rs = stm.executeQuery();
            if(rs.first()){
                 avail =rs.getInt("availability");
            }
            
            
        }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(avail>0){
                return true;
            }
            else{
                return false;
            }
    }
    private void fetchData() {
        try {
            Connection conn = new DbConnect().connect();
            String sql = "select * from stock natural join product natural join cart where user_id = ? ";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,id);
            ResultSet rs = stm.executeQuery();
            render(rs);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        String evt=e.getActionCommand();
        String arr[]=new String[5];
        arr=evt.split("-");
        if(arr[0].equals("desc")){
            Description ob=new Description(arr[1]);
            ob.setVisible(true);
            ob.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        }else if(arr[0].equals("remo")){
            try{
            Connection conn=new DbConnect().connect();
            String sql="delete from cart where stock_id=? and user_id=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setString(1,arr[1]);
            stm.setString(2,arr[2]);
            System.out.println(arr[2]);
            int rs= stm.executeUpdate();
            conn.close();
            displaypanel.removeAll();
            displaypanel.revalidate();
            displaypanel.repaint();
            fetchData();
            
            }
             catch(SQLException el){
            System.out.println(el.getMessage());
        }
            
            
        }
        else if( arr[0].equals("buy")){
            if(checkStock(arr[1])){
              
            try{
            Connection conn=new DbConnect().connect();
            System.out.println("cart id :"+this.id);
            String sql="insert into `transactions`(`user_id`, `stock_id`,  `no.s`, `price`) values(?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setString(1,arr[2]);
            stm.setString(2,arr[1]);
            stm.setString(3,arr[3]);
            stm.setString(4,arr[4]);
            int rs= stm.executeUpdate();
             sql="delete from cart where stock_id=? and user_id=?";
            stm=conn.prepareStatement(sql);
            stm.setString(1,arr[1]);
            stm.setString(2,arr[2]);
            rs= stm.executeUpdate();
            conn.close();
//            displaypanel.removeAll();
//            displaypanel.revalidate();
//            displaypanel.repaint();
//            fetchData();
new Payment(this.id).setVisible(true);
            this.dispose();
            
            }
             catch(SQLException el){
            System.out.println(el.getMessage());
        }
        }
            else{
                JOptionPane.showMessageDialog(null, "Out of Stock");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displaypanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 22, 226));

        jLabel1.setFont(new java.awt.Font("EMERITA Latina", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(215, 219, 23));
        jLabel1.setText("MY CART");

        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Manjari Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(233, 225, 36));
        jLabel2.setText("Total Amount:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(243, 234, 69));
        jLabel3.setText("<label>");

        jButton2.setText("Buy all");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout displaypanelLayout = new javax.swing.GroupLayout(displaypanel);
        displaypanel.setLayout(displaypanelLayout);
        displaypanelLayout.setHorizontalGroup(
            displaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        displaypanelLayout.setVerticalGroup(
            displaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(displaypanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
//        new CustomerProfile().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String os="";
        int idd=0,count=0,count1=0;
        try {
            Connection conn = new DbConnect().connect();
            String sql = "select * from stock natural join cart where user_id = ? ";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                if(checkStock(id)){
                sql= "insert into `transactions`(`user_id`, `stock_id`,  `no.s`, `price`) values(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1,id);
                stm.setString(2,rs.getString("stock_id"));
                stm.setString(3,rs.getString("no.s"));
                stm.setString(4,String.valueOf(rs.getInt("no.s")*rs.getInt("sell_rate")));
                int r= stm.executeUpdate();
                sql= "DELETE from cart where user_id = ? and stock_id = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1,id);
                stm.setString(2,rs.getString("stock_id"));
                 r= stm.executeUpdate();
            }
                else{
                    sql="select product_id from stock where stock_id= ?";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1,rs.getString("stock_id"));
                    rs = stm.executeQuery();
                    if(rs.first()){
                         idd= rs.getInt("product_id");
                    }
                    
                    
                    sql="select product_name from product where product_id= ?";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1,String.valueOf(idd));
                    rs=stm.executeQuery();
                    if(rs.first()){
                        os+=rs.getString("product_name")+",";
                    }
                    count1++;
                }
               count++;
            }
             
            
            conn.close();
//            displaypanel.removeAll();
//            displaypanel.revalidate();
//            displaypanel.repaint();
//            fetchData();
                if(count1==0){
                new Payment(this.id).setVisible(true);}
                
                else{
                    
                    JOptionPane.showMessageDialog(null, os+ " are Out of Stock");
                
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cart1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cart1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cart1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cart1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cart1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel displaypanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
