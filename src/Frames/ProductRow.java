/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.event.ActionEvent;

/**
 *
 * @author aswin
 */
public class ProductRow extends javax.swing.JPanel{
    public ProductRow(){
     initComponents();
    }
    //Variable Declaration
     private javax.swing.JLabel prodCat;
    private javax.swing.JLabel prodName;
    private javax.swing.JLabel prodPrice;
    private javax.swing.JLabel prodStock;
    private javax.swing.JButton prodUpdateBtn;
    //private ProductRow productRow;
    private javax.swing.JLabel stockField;
    private javax.swing.JLabel updateField;
    // End of variables declaration 
    
    //Component initialisation
    private void initComponents(){
        //productRow = new javax.swing.JPanel();
        prodName = new javax.swing.JLabel();
        prodCat = new javax.swing.JLabel();
        prodStock = new javax.swing.JLabel();
        prodPrice = new javax.swing.JLabel();
        prodUpdateBtn = new javax.swing.JButton();
      setBackground(new java.awt.Color(204, 195, 187));

        prodName.setText("<name>");

        prodCat.setText("<category>");

        prodStock.setText("<no.of stock>");

        prodPrice.setText("<price>");

        prodUpdateBtn.setText("Edit");
        prodUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //prodUpdateBtnActionPerformed(evt);
            }         
        });

        javax.swing.GroupLayout productRowLayout = new javax.swing.GroupLayout(this);
        setLayout(productRowLayout);
        productRowLayout.setHorizontalGroup(
            productRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productRowLayout.createSequentialGroup()
                .addComponent(prodName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prodCat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prodStock, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prodUpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        productRowLayout.setVerticalGroup(
            productRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(prodName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(prodCat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(prodStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(productRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(prodPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(prodUpdateBtn))
        );
    }
}
