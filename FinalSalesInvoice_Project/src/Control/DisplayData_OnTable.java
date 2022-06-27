/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.InvoiceHeader;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Select
 */
public class DisplayData_OnTable {
    
     public static void DisplayHeaderTable(Map<Integer, InvoiceHeader> All_Invoices, JTable HeaderTable) {
        
        DefaultTableModel tableModel = (DefaultTableModel) HeaderTable.getModel();
        tableModel.setRowCount(0);
        Object[] row = new Object[4];
        for (InvoiceHeader invoice : All_Invoices.values()) {
            row[0] = invoice.getInv_Num();
            row[1] = invoice.getDate();
            row[2] = invoice.getName();
            row[3] = invoice.getTotal();
            tableModel.addRow(row);
        }
    }
}
