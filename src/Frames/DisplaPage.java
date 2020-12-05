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
import javax.swing.JTextField;
import virtual.market.DbConnect;

/**
 *
 * @author tharikh
 */
public class DisplaPage extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form DisplaPage
     */
    String id, type;
    private ImageIcon format = null;
    String fname = null;
    int s = 0;
    byte[] pimage = null;

    public DisplaPage() {
        initComponents();
        fetchData();
        String cat[] = {"Categories", "Grocery", "Tailoring", "Electronics"};
        category.setModel(new javax.swing.DefaultComboBoxModel(cat));
    }

    public DisplaPage(String id, String type) {
        this();
        this.id = id;
        this.type = type;

    }

    private void render(ResultSet rs) throws SQLException {
        ArrayList arr = new ArrayList<JPanel>();
        JPanel but;
        String stock_id, product_name;
        int avail;
        float rate;
//        Border blackline = BorderFactory.createEmptyBorder(50,50, 50, 50);
        while (rs.next()) {
            rate = rs.getFloat("rate");
            avail = rs.getInt("availability");
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
            JButton cartbut = new JButton("Add to cart");
            JLabel jrate = new JLabel(String.valueOf(rate) + "Rs", SwingConstants.CENTER);
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

            jb.setActionCommand("buy-" + stock_id);
            cartbut.setActionCommand("cart-" + stock_id);
            desc.setActionCommand("desc-" + stock_id);
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

        int i = 30, k = 0, j, m;
        int n = arr.size();
        JPanel temp;
        while (k < n) {
            j = 0;
            m = 10;
            while (j < 3) {
                if (k < n) {
                    temp = (JPanel) arr.get(k);
                    temp.setBounds(m, i, 290, 350);
                    displaypanel.add(temp);
                    m += 315;
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

    private void fetchData() {
        try {
            Connection conn = new DbConnect().connect();
            String sql = "select * from stock natural join product";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            render(rs);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
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
        searchtext = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        category = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displaypanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(40, 116, 240));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VIRTUAL MARKET");

        jButton1.setText("Search");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jButton2.setText("HOME");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(category, 0, 254, Short.MAX_VALUE)
                    .addComponent(searchtext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout displaypanelLayout = new javax.swing.GroupLayout(displaypanel);
        displaypanel.setLayout(displaypanelLayout);
        displaypanelLayout.setHorizontalGroup(
            displaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 953, Short.MAX_VALUE)
        );
        displaypanelLayout.setVerticalGroup(
            displaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        displaypanel.removeAll();
        displaypanel.revalidate();
        displaypanel.repaint();
        
        try{
            Connection conn= new DbConnect().connect();
            String sql="select * from stock natural join product where product_name like ?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setString(1,"%"+searchtext.getText()+"%");
            ResultSet rs=stm.executeQuery();
            render(rs);
            
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        String cat[] = {"Categories", "Grocery", "Tailoring", "Electronics"};
        category.setModel(new javax.swing.DefaultComboBoxModel(cat));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        displaypanel.removeAll();
        displaypanel.revalidate();
        displaypanel.repaint();
        
        try{
            Connection conn= new DbConnect().connect();
            String sql,cat=(String) category.getSelectedItem();
            PreparedStatement stm;
            if(!cat.equals("Categories")){
            sql="select * from stock natural join product where category=?";
            stm=conn.prepareStatement(sql);
            stm.setString(1,cat);
            }
            else{
                sql="select * from stock natural join product";
                stm=conn.prepareStatement(sql);
            }
            
            ResultSet rs=stm.executeQuery();
            render(rs);
            
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        searchtext.setText("");
        

    }//GEN-LAST:event_categoryActionPerformed

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
            java.util.logging.Logger.getLogger(DisplaPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplaPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplaPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplaPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplaPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> category;
    private javax.swing.JPanel displaypanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchtext;
    // End of variables declaration//GEN-END:variables
}
