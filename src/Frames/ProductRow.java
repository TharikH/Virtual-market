/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author aswin
 */
public class ProductRow extends javax.swing.JPanel{
    public ProductRow(StockPage parent,int index,String name,String cat,String stock,String buy,String sell){
        initComponents(name,cat,stock,sell);
        this.parent=parent;
        this.index=index;
        this.buyPrice=Float.valueOf(buy);  
    }
    public ProductRow(StockPage parent,int prodId,int index,String name,String cat,String stock,String buy,String sell,byte[] img){
        this(parent,index,name,cat,stock,buy,sell);
        this.prodId=prodId;
        if(img==null)
            this.img=null;
        else
            this.img=img;
    }
    /* public ProductRow(TestStockPage parent,int index,String name,String cat,String stock,String buy,String sell,ImageIcon img){
        //this(parent,index,name,cat,stock,buy,sell,img);
     initComponents(name,cat,stock,sell);
     this.index=index;
     this.buyPrice=Float.valueOf(buy);
     this.img=img;
     this.parent1=parent;
    }*/
    //Variable Declaration
    private int index;
    private StockPage parent;
//    private TestStockPage parent1;
    private int prodId;
    private float buyPrice;
    private byte[] img;
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
    private void initComponents(String name,String cat,String stock,String sell){
        //productRow = new javax.swing.JPanel();
        
        prodName = new javax.swing.JLabel();
        prodCat = new javax.swing.JLabel();
        prodStock = new javax.swing.JLabel();
        prodPrice = new javax.swing.JLabel();
        prodUpdateBtn = new javax.swing.JButton();
      setBackground(new java.awt.Color(204, 195, 187));
        prodName.setText(name);
        prodCat.setText(cat);
        prodStock.setText(stock);
        prodPrice.setText(sell);
        prodUpdateBtn.setText("Edit");
        prodUpdateBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            parent.setEdit(index);
            //prodUpdateBtnActionPerformed(evt);
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

public String getProdName(){
    System.out.print(prodName.getText());
    return prodName.getText();
}
public String getProdCat(){
    return prodCat.getText();
}
public String getProdStock(){
    return prodStock.getText();
}
public String getProdSell(){
    return prodPrice.getText();
}
public String getProdBuy(){
    return String.valueOf(buyPrice);
}
public String getProdId(){
    return String.valueOf(prodId);
}
public Image getImage() throws Exception{
    return new ImageIcon(img).getImage();
}
public void setProdName(String name){
    prodName.setText(name);
    
}
public void setIndex(int val){
    this.index=val;
    
}
public void setProdCat(String val){
    prodCat.setText(val);
}
public void setProdStock(String val){
    prodStock.setText(val);
}
public void setProdSell(String val){
     prodPrice.setText(val);
}
public void setProdBuy(String val){
    buyPrice=Float.parseFloat(val);
}
public void setProdId(String val){
    prodId=Integer.parseInt(val);
}
public void setImage(byte[] val){
    img=val;
}
public byte[] getImageArray(){
    return img;
}

}
