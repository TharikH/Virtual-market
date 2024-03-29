/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import virtual.market.DbConnect;

/**
 *
 * @author aswin
 */
public class VendorProfile extends javax.swing.JFrame {
    String id,uId="",place,name,state,pin,storeName,district,email,contact,document,shopId="";
    /**
     * Creates new form VendorProfile
     */
    public VendorProfile() {
        initComponents();
    }
     public VendorProfile(String id) {
        this.id=id;
        try{
            fillLabels();
        }
        catch(SQLException e){
            System.out.print("Some Connection error");
            System.out.print(id);
        }
        initComponents();
        documentTField.setEditable(false);
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
        nameLabel = new javax.swing.JLabel();
        addrLabel = new javax.swing.JLabel();
        contactLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameTField = new javax.swing.JTextField();
        stateTField = new javax.swing.JTextField();
        mailTField = new javax.swing.JTextField();
        resetBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        shopAddr2 = new javax.swing.JLabel();
        shopAddr3 = new javax.swing.JLabel();
        shopAddr1 = new javax.swing.JLabel();
        shopNameTField = new javax.swing.JTextField();
        localityTField = new javax.swing.JTextField();
        shopAddr5 = new javax.swing.JLabel();
        shopAddr4 = new javax.swing.JLabel();
        districtTField = new javax.swing.JTextField();
        pinTField = new javax.swing.JTextField();
        contactTField = new javax.swing.JTextField();
        vendorIdLabel = new javax.swing.JLabel();
        shopIdLabel = new javax.swing.JLabel();
        documentLabel = new javax.swing.JLabel();
        documentTField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setText("Vendor Name     :");

        addrLabel.setText("Shop Address:");

        contactLabel.setText("Contact no. :");

        jLabel5.setText("Email :");

        nameTField.setText(name);
        nameTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFieldActionPerformed(evt);
            }
        });

        stateTField.setText(state);
        stateTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateTFieldActionPerformed(evt);
            }
        });

        mailTField.setText(email);

        resetBtn.setText("Reset");

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        shopAddr2.setText("Locality :");

        shopAddr3.setText("District:");

        shopAddr1.setText("Shop Name :");

        shopNameTField.setText(storeName);
        shopNameTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopNameTFieldActionPerformed(evt);
            }
        });

        localityTField.setText(place);

        shopAddr5.setText("State :");

        shopAddr4.setText("PIN Code:");

        districtTField.setText(district);

        pinTField.setText(pin);

        contactTField.setText(contact);

        vendorIdLabel.setText("Vendor id :"+uId);

        shopIdLabel.setText("Shop id :"+shopId);

        documentLabel.setText("Document");

        documentTField.setText(document);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(shopAddr5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contactLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addrLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shopAddr3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shopAddr2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shopAddr1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shopAddr4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mailTField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(localityTField)
                        .addComponent(districtTField)
                        .addComponent(pinTField)
                        .addComponent(stateTField)
                        .addComponent(shopNameTField)
                        .addComponent(nameTField)
                        .addComponent(contactTField, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                    .addComponent(documentTField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(vendorIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(shopIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(documentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendorIdLabel)
                    .addComponent(shopIdLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(addrLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shopAddr1)
                    .addComponent(shopNameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shopAddr2)
                    .addComponent(localityTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shopAddr3)
                    .addComponent(districtTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shopAddr4)
                    .addComponent(pinTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shopAddr5)
                    .addComponent(stateTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactLabel)
                    .addComponent(contactTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mailTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(documentLabel)
                    .addComponent(documentTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetBtn)
                    .addComponent(updateBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFieldActionPerformed

    private void stateTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateTFieldActionPerformed

    private void shopNameTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopNameTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shopNameTFieldActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        try{
            Connection conn=new DbConnect().connect();
            String updateSql="UPDATE `user` SET `name`=?,`email`=?,`phone`=? WHERE id=? AND cust_or_sell='s'";
            if(isValidEmail(mailTField.getText()) && isValidName(nameTField.getText())&&isValidPhone(contactTField.getText())){
                PreparedStatement ps=conn.prepareStatement(updateSql);
                ps.setString(1,nameTField.getText());
                ps.setString(2,mailTField.getText());
                ps.setString(3,contactTField.getText());
                ps.setString(4,id);
                int rs=ps.executeUpdate();
                if (rs!=0){
                  System.out.print("user section updated");
                }
                conn.close();
            }
            
            
        }
        catch(Exception e){
            System.out.print(e);
        }
        try{
            Connection conn=new DbConnect().connect();
            if(shopId.equals("") || shopId==null){
               String insertSql="INSERT INTO `shop`( `shop_name`, `state`, `district`, `locality`,`seller_id`, `pincode`) VALUES (?,?,?,?,?,?) ";
                if(isValidName(shopNameTField.getText()) && isValidName(localityTField.getText())&&isValidName(districtTField.getText())&&isValidName(stateTField.getText())&&isValidName(pinTField.getText())){
                    PreparedStatement ps=conn.prepareStatement(insertSql);
                    ps.setString(1,shopNameTField.getText());
                    ps.setString(2,stateTField.getText());
                    ps.setString(3,districtTField.getText());
                    ps.setString(4,localityTField.getText());
                    ps.setString(5,uId);
                    ps.setString(6,pinTField.getText());
                    int rs=ps.executeUpdate();
                if (rs!=0){
                  System.out.print("new shop inserted");
                }
            }
                else{
                    throw(new SQLException());
                }
            }
            else{
                String updateSql="UPDATE `shop` SET `shop_name`=?,`state`=?,`district`=?,`locality`=?,`pincode`=? WHERE seller_id="+uId;
                if(isValidName(shopNameTField.getText()) && isValidName(localityTField.getText())&&isValidName(districtTField.getText())&&isValidName(stateTField.getText())&&isValidName(pinTField.getText())){
                    PreparedStatement ps=conn.prepareStatement(updateSql);
                    ps.setString(1,shopNameTField.getText());
                    ps.setString(2,stateTField.getText());
                    ps.setString(3,districtTField.getText());
                    ps.setString(4,localityTField.getText());
                    ps.setString(5,pinTField.getText());
                    int rs=ps.executeUpdate();
                    if (rs!=0){
                        System.out.print("shop section updated");
                }
            }
                else{
                    throw(new SQLException());
                }
                
            }
           
            
          conn.close();  
        }
        catch(SQLException e){
            System.out.print(e);
        }
        
    }//GEN-LAST:event_updateBtnActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VendorProfile().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addrLabel;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JTextField contactTField;
    private javax.swing.JTextField districtTField;
    private javax.swing.JLabel documentLabel;
    private javax.swing.JTextField documentTField;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField localityTField;
    private javax.swing.JTextField mailTField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTField;
    private javax.swing.JTextField pinTField;
    private javax.swing.JButton resetBtn;
    private javax.swing.JLabel shopAddr1;
    private javax.swing.JLabel shopAddr2;
    private javax.swing.JLabel shopAddr3;
    private javax.swing.JLabel shopAddr4;
    private javax.swing.JLabel shopAddr5;
    private javax.swing.JLabel shopIdLabel;
    private javax.swing.JTextField shopNameTField;
    private javax.swing.JTextField stateTField;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel vendorIdLabel;
    // End of variables declaration//GEN-END:variables
private void fillLabels() throws SQLException {
    Connection conn=new DbConnect().connect();
    String sqlUser="SELECT * FROM user WHERE id="+id+" AND cust_or_sell='s'";
    Statement st=conn.createStatement( );
    ResultSet rs = st.executeQuery(sqlUser);
    if(rs.next()){
        name=rs.getString("name");
        uId=rs.getString("uniqueID");
        email=rs.getString("email");
        contact=rs.getString("phone");
        document=rs.getString("document");
        System.out.print(rs.getString("name"));
        String sqlStore="SELECT * FROM shop WHERE seller_id="+uId;
        ResultSet rs1=st.executeQuery(sqlStore);
        if(rs1.next()){
            place=rs1.getString("locality");
            shopId=rs1.getString("shop_id");
            storeName=rs1.getString("shop_name");
            district=rs1.getString("district");
            state=rs1.getString("state");
            pin=rs1.getString("pincode");
        }
        
       
    }
    
}
    private boolean isValidEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX
                = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    private boolean isValidName(String name) {
        return !name.equals("");
    }
    private boolean isValidPhone(String number) {
        String regex = "[0-9]+";
        return number.matches(regex) && number.length() == 10;
    }
   
}
