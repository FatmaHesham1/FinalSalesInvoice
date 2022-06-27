/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Map;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import View.Create_New_Inv;
import View.Create_New_Line;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class NewLine_Handler {
    


    public static void AddNew_Line(JTable LineTable, int index){
        new Create_New_Line(null, true, index).show();
        InvoiceLine InvoiceLine  = Create_New_Line.getNewItem();
        
        if(InvoiceLine != null){
            DefaultTableModel model = (DefaultTableModel)LineTable.getModel();
            Object[] row = new Object[5];
            row[0] = InvoiceLine.getInv_Num();
            row[1] =InvoiceLine.getItem_Name();
            row[2] = InvoiceLine.getPrice();
            row[3] = InvoiceLine.getItem_count();
            row[4] = InvoiceLine.getTotalPrice();
            model.addRow(row);
        }
    }
    
}
