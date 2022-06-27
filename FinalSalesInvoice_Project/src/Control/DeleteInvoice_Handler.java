
package Control;

import Model.InvoiceHeader;
import java.util.Map;
import javax.swing.JTable;


public class DeleteInvoice_Handler {
    
           
    
    private static DisplayData_OnTable display;

        public static void DeleteInvoice(JTable table, Map<Integer,InvoiceHeader> invoices, int key){
            
        invoices.remove(key);
        display.DisplayHeaderTable(invoices, table);
    }
    
}
