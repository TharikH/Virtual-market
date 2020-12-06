/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import virtual.market.DbConnect;

/**
 *
 * @author aswin
 */
public class StockPage extends javax.swing.JFrame{
   //Variable Declaration
    private static int index=-1;
    String id,shopId;
    private ImageIcon format=null;
    byte[] pimage=null,def=null;
    //private StockPage context;
    //String[][] pr={{"Apple","Fruit","15","30","40"},{"Mango","Fruit","10","35","50"},{"7up","Drinks","20","30","35"}};
    //String[] pr2={"Mango","Fruit","10","35","50"};
   // String[] pr3={"7up","Drinks","20","30","35"};
    private javax.swing.JLabel catField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel priceField;
    private javax.swing.JLabel stockField;
    private javax.swing.JLabel updateField;
    private javax.swing.JLabel imageLabel;
    private ProductRow productRow;
    private ProductRow productRow1;
    private ArrayList<ProductRow> products;
    private javax.swing.JPanel productDetails;
    private javax.swing.JPanel scrollPanel;
    private static javax.swing.JLabel addStock;
    private static javax.swing.JTextField addStockTField;
    private static javax.swing.JTextField buyTField;
    //private javax.swing.JLabel catField;
    private static javax.swing.JTextField catTField;
    private javax.swing.JLabel editBuy;
    private javax.swing.JLabel editCat;
    private javax.swing.JLabel editName;
    private javax.swing.JLabel editSell;
    private javax.swing.JLabel editStock;
    private static javax.swing.JTextField nameTField;
    private static javax.swing.JTextField stockTField;
    private static javax.swing.JTextField sellTField;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton browseImg;
    private javax.swing.JButton deleteBtn;
    //Constructor
    public StockPage(){
        initVar();
        //products.add(new ProductRow(this,1,0,"Mountain","Drinks","10","30","40"));
        initComponents();
    }
    public StockPage(String id,String shopId){
        this.id=id;
        this.shopId =shopId;
        initVar();
        try{
            getStock();
        }
        catch(SQLException e){
            System.out.print("error occured"+e);
        }
        initComponents();
    }
    
//Component declaration
    private void initComponents() {
        
       // productRow=new ProductRow();
        //productRow1=new ProductRow();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(40, 116, 240));

       jPanel1.setBackground(new java.awt.Color(40, 116, 240));

        scrollPanel.setBackground(new java.awt.Color(40, 116, 240));

        jPanel2.setBackground(new java.awt.Color(175, 198, 218));

        jPanel3.setBackground(new java.awt.Color(146, 142, 136));

        nameField.setText("Name");

        catField.setText("Category");

        stockField.setText("Avail. Stock");

        priceField.setText("Price");

        updateField.setText("Update");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(catField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateField, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(catField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stockField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(priceField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(updateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            /*
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(productRow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)        
                .addGap(0, 0, Short.MAX_VALUE)

                */getHorizontalGroup(jPanel2Layout,products)
              
                
                
        );
        
        
        jPanel2Layout.setVerticalGroup(
           /*
                 jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(productRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) 
                    .addComponent(productRow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 428, Short.MAX_VALUE))
                */
                getVerticalGroup(jPanel2Layout,products)
            
        );
        //Product Detail Section

        //End of Product Detail Section

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout scrollPanelLayout = new javax.swing.GroupLayout(scrollPanel);
        scrollPanel.setLayout(scrollPanelLayout);
        scrollPanelLayout.setHorizontalGroup(
            scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
            .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scrollPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        scrollPanelLayout.setVerticalGroup(
            scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
        );

        editName.setText("Name:");

        editCat.setText("Category:");

        editStock.setText("Stock:");

        addStock.setText("Add Stock:");

        editBuy.setText("Buy Price:");

        editSell.setText("Sell Price:");

        resetBtn.setText("Reset");
        resetBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            resetBtnActionPerformed();
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            try{
                updateBtnActionPerformed(evt);
            }
            catch(Exception e){
                System.out.print("\nerror occured while updating "+e.getClass());
            }
        });
        saveBtn.setText("Save");
        saveBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            try{
                saveBtnActionPerformed(evt);
            }
            catch(Exception e){
                System.out.print("\nerror occured while adding "+e);
            }
        });

        buyTField.addActionListener((java.awt.event.ActionEvent evt) -> {
            // buyTFieldActionPerformed(evt);
        });

       imageLabel.setText("<img>");

        browseImg.setText("Browse");
        browseImg.addActionListener((java.awt.event.ActionEvent evt) -> {
            try{
                browseImgActionPerformed(evt);
            }
            catch(NullPointerException e){
                System.out.print("\n error was thrown while canceling image window"+e);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            try{
                deleteActionPerformed(evt);
            }
            catch(Exception e){
                System.out.print("\n error was thrown while canceling image window"+e);
            }
        });
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(editCat, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(editName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTField)
                            .addComponent(catTField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(stockTField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addStock, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(addStockTField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(browseImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editStock, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(editSell, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buyTField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sellTField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseImg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStockTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSell, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetBtn)
                    .addComponent(updateBtn)
                    .addComponent(saveBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>
    private ParallelGroup getHorizontalGroup(javax.swing.GroupLayout layout,ArrayList<ProductRow> products){
        ParallelGroup g=layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        
        g.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            //.addComponent(productRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
           // .addComponent(productRow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE); 
         for(ProductRow p:products)
             g.addComponent(p);
        g.addGap(0, 0, Short.MAX_VALUE);
        return g;
    }
    private ParallelGroup getVerticalGroup(javax.swing.GroupLayout layout,ArrayList<ProductRow> products){
        ParallelGroup pg=layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        SequentialGroup sg=layout.createSequentialGroup();
        sg.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
         // .addComponent(productRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) 
         // .addComponent(productRow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        for(ProductRow p:products)
             sg.addComponent(p);
            sg.addGap(0, 428, Short.MAX_VALUE);
        pg .addGroup(sg);
        return pg;
    }
    public ImageIcon resizeImage(String imagePath, byte[] pic){
          
        ImageIcon myImage=null;
       if(imagePath !=null)
        {
            myImage=new ImageIcon(imagePath);
        
        }else{
         myImage=new ImageIcon(pic);
        }
                
        Image img=myImage.getImage();
        Image img2=img.getScaledInstance(imageLabel.getHeight(),    imageLabel.getWidth(),  Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(img2);
        return image;
    }
    private void browseImgActionPerformed(java.awt.event.ActionEvent evt) throws NullPointerException {                                          
        // TODO add your handling code here:
        //To insert an image
        JFileChooser fchoser=new JFileChooser();
        fchoser.showOpenDialog(null);
        File f=fchoser.getSelectedFile();
        String fname=f.getAbsolutePath();
       ImageIcon micon=new ImageIcon(fname);        
        try {
            File image=new File(fname);
            FileInputStream fis=new FileInputStream(image);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            for(int readnum; (readnum=fis.read(buf)) !=-1;)
            {            
               baos.write(buf,0,readnum);                
            }
            pimage=baos.toByteArray();
            imageLabel.setIcon(resizeImage(fname, buf));
        } catch (Exception e) {
            System.out.println("Cannot do it");
        }
    }
    public void setEdit(int val){
        this.index=val;
        setEditPanel(this.index);
    }
    //set values in edit panel when edit btn is clicked
    private void setEditPanel(int val){
        ProductRow temp=products.get(val);
        try{
        Image img=temp.getImage();
        img=img.getScaledInstance(imageLabel.getWidth(),imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        }
        catch(Exception e){
            System.out.print("Cannot load image");
        }
        
        //System.out.print(temp.getName()+"\n"+temp.getProdCat());
        nameTField.setText(temp.getProdName());
        catTField.setText(temp.getProdCat());
        stockTField.setText(temp.getProdStock());
        buyTField.setText(temp.getProdBuy());
        sellTField.setText(temp.getProdSell());
    }
    //reset btn action
    public void resetBtnActionPerformed(){
        this.index=-1;
        pimage=null;
        imageLabel.removeAll();
        imageLabel.revalidate();
        imageLabel.repaint();
        imageLabel.setText("No image");
        nameTField.setText("");
        catTField.setText("");
        stockTField.setText("");
        buyTField.setText("");
        sellTField.setText("");
    }
    //Variable declaration
    private void initVar(){
        imageLabel = new javax.swing.JLabel();
        browseImg = new javax.swing.JButton();
        deleteBtn=new javax.swing.JButton();
        //products.add(new ProductRow(this,0,pr[0][0],pr[0][1],pr[0][2],pr[0][4]));
        //products.add(new ProductRow(this,1,pr[1][0],pr[1][1],pr[1][2],pr[1][4]));
        //products.add(new ProductRow(this,2,pr[2][0],pr[2][1],pr[2][2],pr[2][4]));
       jPanel1 = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        nameField = new javax.swing.JLabel();
        catField = new javax.swing.JLabel();
        stockField = new javax.swing.JLabel();
        priceField = new javax.swing.JLabel();
        updateField = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        editName = new javax.swing.JLabel();
        editCat = new javax.swing.JLabel();
        editStock = new javax.swing.JLabel();
        nameTField = new javax.swing.JTextField();
        catTField = new javax.swing.JTextField();
        stockTField = new javax.swing.JTextField();
        addStock = new javax.swing.JLabel();
        addStockTField = new javax.swing.JTextField();
        editBuy = new javax.swing.JLabel();
        editSell = new javax.swing.JLabel();
        sellTField = new javax.swing.JTextField();
        resetBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        buyTField = new javax.swing.JTextField(); 
        System.out.print(products);
        products=new ArrayList<ProductRow>();
        products.add(new ProductRow(this,1,products.size(),"Mountain","Drinks","10","30","40",null));
    }
    
    //Get value from Database
    private void getStock() throws SQLException{
        products=new ArrayList<ProductRow>();
        Connection conn=new DbConnect().connect();
        String sqlProds="SELECT P.product_id,P.product_name,P.category,S.availability,S.buy_rate,S.sell_rate,S.img "
                + "FROM product P, stock S "
                + "WHERE P.product_id=S.product_id "
                + "AND S.shop_id="+id;
        System.out.print("SELECT P.product_id,P.product_name,P.category,S.availability,S.buy_rate,S.sell_rate,S.img "
                + "FROM product P, stock S "
                + "WHERE P.product_id=S.product_id "
                + "AND S.shop_id="+id);
        Statement st=conn.createStatement( );
        ResultSet rs=st.executeQuery(sqlProds);
        while(rs.next()){
            System.out.print(rs.getString("product_id"));
            
            products.add(new ProductRow(this,Integer.parseInt(rs.getString("product_id")),products.size(),rs.getString("product_name"),rs.getString("category"),rs.getString("availability"),rs.getString("buy_rate"),rs.getString("sell_rate"),rs.getBytes("img")));
        }
        
    }
    private void saveBtnActionPerformed (java.awt.event.ActionEvent evt) throws Exception{                                        
        // TODO add your handling code here:
        if (index!=-1) throw( new NullPointerException());
        if(nameTField.getText().equals("")||catTField.getText().equals("")||stockTField.getText().equals("")||buyTField.getText().equals("")||sellTField.getText().equals(""))
            throw(new NullPointerException());

        else{
            if(pimage==null){
                //System.out.print(imageLabel.getIcon());
                products.add(new ProductRow(this,-1,products.size(),nameTField.getText(),catTField.getText(),stockTField.getText(),buyTField.getText(),sellTField.getText(),def));
            }
         else{
                products.add(new ProductRow(this,-1,products.size(),nameTField.getText(),catTField.getText(),stockTField.getText(),buyTField.getText(),sellTField.getText(),pimage));
            }
        }
        try{
            insertDb(products.size()-1);
        }
        catch(SQLException e)
        {
            System.out.print("\nCannot add into DB "+e);
        }
        repaintPanel();
    }
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt)throws NullPointerException,SQLException{
        if (index==-1)throw( new NullPointerException());
        
        int tempStock=Integer.parseInt(stockTField.getText());
        try{
        if(addStockTField.getText().equals(""))
            tempStock+=Integer.parseInt(addStockTField.getText());
        }
        catch(NumberFormatException e){
            System.out.print("\n Error due to null value in add stock");
        }
        ProductRow pr=products.get(index);
        pr.setProdName(nameTField.getText());
        pr.setProdCat(catTField.getText());
        pr.setProdStock(String.valueOf(tempStock));
        pr.setProdBuy(buyTField.getText());
         pr.setProdSell(sellTField.getText());
        addStockTField.setText("");
        if(pimage==null) { 
            
        }
        else {
           pr.setImage(pimage);    
        }
        updateDb(index);
        resetBtnActionPerformed();
        //repaintPanel();
        
    }
    //Delete Row
    private void deleteActionPerformed(java.awt.event.ActionEvent evt)throws Exception{
        if (index==-1)throw( new NullPointerException());
        deleteDb(index);
        products.remove(index);
        repaintPanel();
        resetBtnActionPerformed();
    }
    private void repaintPanel() throws Exception{
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
        getHorizontalGroup(jPanel2Layout,products) 
        );
        jPanel2Layout.setVerticalGroup(
        getVerticalGroup(jPanel2Layout,products)     
        );
    }
    private void insertDb(int val) throws SQLException{
        Connection conn=new DbConnect().connect();
        ProductRow pr= products.get(val);
        String checkSql="SELECT product_id FROM `product` WHERE product_name=? AND category=? ";
        PreparedStatement ps=conn.prepareStatement(checkSql);
        ps.setString(1, pr.getProdName());
        ps.setString(2, pr.getProdCat());
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            pr.setProdId(rs.getString("product_id"));
        }
        else
        {
            String insertProdSql="INSERT INTO `product`( `product_name`, `category`) VALUES (?,?)" ;
            PreparedStatement ps1=conn.prepareStatement(insertProdSql);
            ps1.setString(1, pr.getProdName());
            ps1.setString(2, pr.getProdCat());
            rs=ps.executeQuery();
            pr.setProdId(rs.getString("product_id"));
        }
        String insertStockSql="INSERT INTO `stock`( `product_id`, `availability`, `buy_rate`, `sell_rate`, `shop_id`, `img`) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps2=conn.prepareStatement(insertStockSql);
        ps2.setInt(1, Integer.parseInt(pr.getProdId()));
        ps2.setInt(2, Integer.parseInt(pr.getProdStock()));
        ps2.setFloat(3, Float.parseFloat(pr.getProdBuy()));
        ps2.setFloat(4, Float.parseFloat(pr.getProdSell()));
        ps2.setInt(5, Integer.parseInt(id));
        ps2.setBytes(6, pr.getImageArray());
        int result=ps2.executeUpdate();
        if(result==0)
            throw(new SQLException());
        else
            System.out.print("Item inserted into table");
    
    }
    private void updateDb(int val) throws SQLException{
        Connection conn=new DbConnect().connect();
        ProductRow pr= products.get(val);
        String updateSql="UPDATE `stock` SET `availability`=?,`buy_rate`=?,`sell_rate`=?,`img`=? WHERE shop_id=? AND product_id=?";
        PreparedStatement ps=conn.prepareStatement(updateSql);
        ps.setInt(1, Integer.parseInt(pr.getProdStock()));
        ps.setFloat(2, Float.parseFloat(pr.getProdBuy()));
        ps.setFloat(3, Float.parseFloat(pr.getProdSell()));
        ps.setBytes(4,pr.getImageArray());
        ps.setInt(5,Integer.parseInt(id));
        ps.setInt(6,Integer.parseInt(pr.getProdId()));
        int rs=ps.executeUpdate();
        if (rs==0)
            throw(new SQLException());
        else
            System.out.print("Item updated");
    }
    private void deleteDb(int val) throws SQLException{
        Connection conn=new DbConnect().connect();
        ProductRow pr= products.get(val);
        String deleteSql="DELETE FROM `stock` WHERE shop_id=? AND product_id=?";
        PreparedStatement ps=conn.prepareStatement(deleteSql);
        ps.setInt(1,Integer.parseInt(id));
        ps.setInt(2,Integer.parseInt(pr.getProdId()));
        int rs=ps.executeUpdate();
        if (rs==0)
            throw(new SQLException());
        else
            System.out.print("Item deleted");
    }
}
