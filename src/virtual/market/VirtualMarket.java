/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.market;
import Frames.*;
import java.sql.Connection;
/**
 *
 * @author tharikh
 */
public class VirtualMarket {

    /**
     * @param args the command line arguments
     */
    static Connection conn=null;
    public static void main(String[] args) {
        // TODO code application logic here
        new LoginPage().setVisible(true);
    }
    
}
