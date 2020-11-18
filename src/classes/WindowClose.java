/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Frames.LoginPage;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author tharikh
 */
public class WindowClose extends WindowAdapter{
    public void windowClosed(WindowEvent e){
        new LoginPage().setVisible(true);
    }
}
