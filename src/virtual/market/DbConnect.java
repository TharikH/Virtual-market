/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.market;
import java.sql.*;
/**
 *
 * @author tharikh
 */
public class DbConnect {
    private String url="jdbc:mysql://localhost:3306/VirtualMarket";
    private String pass="";
    private String user="root";
    Connection con=null;
    public Connection connect() throws SQLException{
        try{
            con=DriverManager.getConnection(url,user,pass);
            System.out.println("connected!");
           
        }
        catch(SQLException e){
             System.out.println(e.getMessage());
        }
        return con;
    }
    
}
