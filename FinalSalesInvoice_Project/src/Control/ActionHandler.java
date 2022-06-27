/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import View.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Select
 */
public class ActionHandler implements ActionListener {

    
    private MainForm frame;
    public ActionHandler(MainForm frame) {
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 System.out.println("Action handling called");
        
        switch(e.getActionCommand()){
        case("New Invoice"):
            
            break;
        
        case("Delete Invoice"):
            
            break;
            
        case("New Item"):
            
            break;
            
        case("Delete Item"):
            
            break;
            
        case("Load File"):
            break;
            
        case("Save File"):
            
            break;
        
        
        }
                
    }


    }
    

