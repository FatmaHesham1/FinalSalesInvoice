/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.InvoiceHeader;
import View.Create_New_Inv;
import java.util.Map;
import javax.swing.JTable;

/**
 *
 * @author Select
 */
public class NewInvoice_Handler {
    
    
       private static DisplayData_OnTable display;
       private static LoadSave_Handler handler;
    
     public static void AddNewInvoice(Map<Integer, InvoiceHeader> All_Invoices, JTable HeaderTable){
         new Create_New_Inv(null, true, String.valueOf(InvoiceHeader.counter)).show();
         
        InvoiceHeader InvoiceHeader = Create_New_Inv.getCreatedInvoice();
        
        if (InvoiceHeader != null) {
            
           All_Invoices.put(InvoiceHeader.getInv_Num(), InvoiceHeader);
            
            display.DisplayHeaderTable(All_Invoices, HeaderTable);
        }
     }
      
}
