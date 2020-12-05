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
    byte[] pimage=null;
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
    //Constructor
    public StockPage(){
        initVar();
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
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed();
            }
        });

        updateBtn.setText("Update");

        saveBtn.setText("Save");

        buyTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // buyTFieldActionPerformed(evt);
            }
        });

       imageLabel.setText("<img>");

        browseImg.setText("Browse");
        browseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               try{ 
                   browseImgActionPerformed(evt);
               }
               catch(NullPointerException e){
                   System.out.print("\n error was thrown while canceling image window"+e);
               }
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
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(editSell, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editStock, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(editBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buyTField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sellTField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(stockTField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addStock, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(addStockTField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(browseImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            products.add(new ProductRow(this,Integer.parseInt(rs.getString("product_id")),products.size(),rs.getString("product_name"),rs.getString("category"),rs.getString("availability"),rs.getString("buy_rate"),rs.getString("sell_rate"),new ImageIcon(rs.getBytes("img"))));
        }
        
    }
}
