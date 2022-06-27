/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import javax.swing.JOptionPane;

/**
 *
 * @author Select
 */
public class MessageDialog_Handler {

    public MessageDialog_Handler() {
    }
    
    
    public void showDialog(String msg,String msgType){
        if(msgType.equalsIgnoreCase("info")){
            JOptionPane.showMessageDialog(null, msg, "Sales Invoice Generator Project", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (msgType.equalsIgnoreCase("error")){
            JOptionPane.showMessageDialog(null, msg, "Sales Invoice Generator Project", JOptionPane.ERROR_MESSAGE);
        } 
       
    
    }
    
    
}
