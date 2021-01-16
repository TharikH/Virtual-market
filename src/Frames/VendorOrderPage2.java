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
public class VendorOrderPage2 extends javax.swing.JFrame implements ActionListener {

    //id of the shop
     String id="2";
     //id of customer to display his products
     int user_id;
    private ImageIcon format = null;
    String fname = null;
    int s = 0;
    ArrayList<String> arrName;
    ArrayList<Integer> arrId;
    byte[] pimage = null;
    
    public VendorOrderPage2() {
        initComponents();
        setCat();
        //fetchData();
    }
    
    public VendorOrderPage2(String id) {
        this.id = id;
        initComponents();
        //fetchData();
    }

        private void render(ResultSet rs) throws SQLException {
        ArrayList arrProds = new ArrayList<JPanel>();
        JPanel but;
        String stock_id, product_name;
        int num;
        float rate;
        System.out.print("here");
        int sum=0;
//        Border blackline = BorderFactory.createEmptyBorder(50,50, 50, 50);
        while (rs.next()) {
            System.out.print(rs.getString("product_name"));
            rate = rs.getFloat("sell_rate");
            num = rs.getInt("quantity");
            stock_id = rs.getString("stock_id");
            product_name = rs.getString("product_name");
            byte[] imagedata = rs.getBytes("img");
            format = new ImageIcon(imagedata);
            Image mm = format.getImage();
            
            JButton desc = new JButton("Description");
            JPanel jp = new JPanel();
            JLabel jl = new JLabel();
            JButton jb = new JButton("Accept");
            JLabel jname = new JLabel(product_name.toUpperCase(), SwingConstants.CENTER);
            JButton cartbut = new JButton("Reject");
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
            int val=buyers.getSelectedIndex();
            jb.setActionCommand("buy-" + stock_id+"-"+arrId.get(val));
            cartbut.setActionCommand("remo-" + stock_id+"-"+arrId.get(val));
            desc.setActionCommand("desc-" + stock_id+"-"+arrId.get(val));
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
            arrProds.add(jp);
        }
        
        jLabel3.setText(String.valueOf(sum));

        int i = 30, k = 0, j, m;
        int n = arrProds.size();
        JPanel temp;
        if(n==0)
            setCat();
        while (k < n) {
            j = 0;
            m = 10;
            while (j < 3) {
                if (k < n) {
                    temp = (JPanel) arrProds.get(k);
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
        //all products of the selected customer
    private void fetchData(int val) {
        try {
            user_id=arrId.get(val);
            System.out.print("user_id:");
            System.out.print(user_id);
            Connection conn = new DbConnect().connect();
            
            String sql = "select * from stock natural join product natural join view_transaction where shop_id =? and user_id=? and status='0'" ;
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,Integer.parseInt(id));
            stm.setInt(2, arrId.get(val));
            ResultSet rs = stm.executeQuery();
            //System.out.print(rs.next());
            System.out.print(stm);
            render(rs);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //action performed on the product card
    public void actionPerformed(ActionEvent e) {
        String evt=e.getActionCommand();
        String arr[]=new String[3];
        arr=evt.split("-");
        if(arr[0].equals("desc")){
            Description ob=new Description(arr[1]);
            ob.setVisible(true);
            ob.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        //when reject button is clicked in product
        }else if(arr[0].equals("remo")){
            try{
             System.out.println("here");  
            Connection conn=new DbConnect().connect();
            //String sql="delete from virtual_order where stock_id=? and user_id=?";
            String sql_transact="update virtual_transaction set status='-1'  where stock_id=? and user_id=?";
            PreparedStatement stm_transact=conn.prepareCall(sql_transact);
            stm_transact.setInt(1,Integer.parseInt(arr[1]));
            stm_transact.setInt(2,Integer.parseInt(arr[2]));
            System.out.println(stm_transact);
            int rs= stm_transact.executeUpdate();
            conn.close();
            displaypanel.removeAll();
            displaypanel.revalidate();
            displaypanel.repaint();
            fetchData(buyers.getSelectedIndex());
            
            }
             catch(SQLException el){
            System.out.println(el.getMessage());
        }
            
            
        }
        //when accept button is clicked in product
        else if( arr[0].equals("buy")){
            try{
             System.out.println("here");  
            Connection conn=new DbConnect().connect();
            //String sql="delete from virtual_order where stock_id=? and user_id=?";
            String sql_transact="update virtual_transaction set status='1'  where stock_id=? and user_id=?";
            PreparedStatement stm_transact=conn.prepareCall(sql_transact);
            stm_transact.setInt(1,Integer.parseInt(arr[1]));
            stm_transact.setInt(2,Integer.parseInt(arr[2]));
            
            //PreparedStatement stm=conn.prepareStatement(sql);
           // stm.setInt(1,Integer.parseInt(arr[1]));
            //stm.setInt(2,Integer.parseInt(arr[2]));
            System.out.println(stm_transact);
            //System.out.println(arr[2]);
            int rs= stm_transact.executeUpdate();
            conn.close();
            displaypanel.removeAll();
            displaypanel.revalidate();
            displaypanel.repaint();
            fetchData(buyers.getSelectedIndex());
            
            }
             catch(SQLException el){
            System.out.println(el.getMessage());
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
        acceptAllBtn = new javax.swing.JButton();
        rejectAllBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displaypanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        buyers = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 22, 226));

        jLabel1.setFont(new java.awt.Font("EMERITA Latina", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(215, 219, 23));
        jLabel1.setText("ORDER PAGE");

        jButton1.setText("HOME");

        jLabel2.setFont(new java.awt.Font("Manjari Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(233, 225, 36));
        jLabel2.setText("Total Amount:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(243, 234, 69));
        jLabel3.setText("<label>");

        acceptAllBtn.setText("Accept All");
        acceptAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptAllBtnActionPerformed(evt);
            }
        });

        rejectAllBtn.setText("Reject All");
        rejectAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectAllBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(acceptAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(rejectAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(acceptAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rejectAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jLabel4.setText("Order Name :");

        buyers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        buyers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(buyers, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(buyers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void buyersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyersActionPerformed
        // TODO add your handling code here:
        System.out.print(buyers.getSelectedIndex());
        displaypanel.removeAll();
        displaypanel.revalidate();
        displaypanel.repaint();
        fetchData(buyers.getSelectedIndex());
    }//GEN-LAST:event_buyersActionPerformed

    private void acceptAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptAllBtnActionPerformed
        // TODO add your handling code here:
        try{
             System.out.println("here");  
            Connection conn=new DbConnect().connect();
            //String sql="delete from virtual_order where stock_id=? and user_id=?";
            String sql_transact="update virtual_transaction set status='1'  where transaction_id=(select order_id from view_transaction where shop_id=? and user_id=?)";
            PreparedStatement stm_transact=conn.prepareCall(sql_transact);
            stm_transact.setInt(1,Integer.parseInt(id));
            stm_transact.setInt(2,user_id);
            //PreparedStatement stm=conn.prepareStatement(sql);
           // stm.setInt(1,Integer.parseInt(arr[1]));
            //stm.setInt(2,Integer.parseInt(arr[2]));
            System.out.println(stm_transact);
            //System.out.println(arr[2]);
            int rs= stm_transact.executeUpdate();
            conn.close();
            displaypanel.removeAll();
            displaypanel.revalidate();
            displaypanel.repaint();
            fetchData(buyers.getSelectedIndex());
            
            }
             catch(SQLException el){
            System.out.println(el.getMessage());
        }
        
    }//GEN-LAST:event_acceptAllBtnActionPerformed
    //to Accept all products
    private void rejectAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectAllBtnActionPerformed
        // TODO add your handling code here:
        try{
             System.out.println("here");  
            Connection conn=new DbConnect().connect();
            //String sql="delete from virtual_order where stock_id=? and user_id=?";
            String sql_transact="update virtual_transaction set status='-1'  where transaction_id=(select order_id from view_transaction where shop_id=? and user_id=?)";
            PreparedStatement stm_transact=conn.prepareCall(sql_transact);
            stm_transact.setInt(1,Integer.parseInt(id));
            stm_transact.setInt(2,user_id);
            
            //PreparedStatement stm=conn.prepareStatement(sql);
           // stm.setInt(1,Integer.parseInt(arr[1]));
            //stm.setInt(2,Integer.parseInt(arr[2]));
            System.out.println(stm_transact);
            //System.out.println(arr[2]);
            int rs= stm_transact.executeUpdate();
            conn.close();
            displaypanel.removeAll();
            displaypanel.revalidate();
            displaypanel.repaint();
            fetchData(buyers.getSelectedIndex());
            
            }
             catch(SQLException el){
            System.out.println(el.getMessage());
        }
    }//GEN-LAST:event_rejectAllBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VendorOrderPage2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorOrderPage2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorOrderPage2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorOrderPage2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorOrderPage2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptAllBtn;
    private javax.swing.JComboBox<String> buyers;
    private javax.swing.JPanel displaypanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rejectAllBtn;
    // End of variables declaration//GEN-END:variables
private void setCat(){
        arrName=new ArrayList();
        arrId=new ArrayList<Integer>();
        arrName.add(" ");
        arrId.add(-1);
        try{
            Connection con=new DbConnect().connect();
            String sql="SELECT name,id FROM user WHERE id IN (select DISTINCT user_id from view_transaction where shop_id=? and status='0') ";
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                arrName.add(rs.getString("name"));
                arrId.add(rs.getInt("id"));
            }
            String cat[] =new String[arrName.size()];
            cat=arrName.toArray(cat);
        buyers.setModel(new javax.swing.DefaultComboBoxModel(cat));
        
        con.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
