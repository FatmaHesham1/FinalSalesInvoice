/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.DeleteInvoice_Handler;
import Control.DisplayData_OnTable;
import Control.LoadSave_Handler;
import Control.MessageDialog_Handler;
import Control.NewLine_Handler;
import Control.NewInvoice_Handler;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import java.awt.HeadlessException;
import static java.lang.String.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainForm extends javax.swing.JFrame {

    Map<Integer, InvoiceHeader> All_Invoices;
    DisplayData_OnTable display;
    MessageDialog_Handler msg;

    public MainForm() {
        initComponents();

        All_Invoices = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        HeaderTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LineTable = new javax.swing.JTable();
        Inv_No = new javax.swing.JLabel();
        Inv_Total = new javax.swing.JLabel();
        NewInv_Btn = new javax.swing.JButton();
        Dele_Inv_Btn = new javax.swing.JButton();
        NewLine_Btn = new javax.swing.JButton();
        DeleteLine_Btn = new javax.swing.JButton();
        Inv_date = new javax.swing.JLabel();
        Inv_name = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        LoadItem = new javax.swing.JMenuItem();
        MenuItem_save = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales invoice generator");
        setResizable(false);

        HeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        HeaderTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        HeaderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                HeaderTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(HeaderTable);

        jLabel1.setText("Invoices Table");

        jLabel2.setText("Invoice Number");

        jLabel3.setText("Invoice Date");

        jLabel4.setText("Customer Name");

        jLabel5.setText("Invoice Total");

        jLabel6.setText("Invoice Lines");

        LineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LineTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(LineTable);

        Inv_No.setText("0");

        Inv_Total.setText("0");

        NewInv_Btn.setText("Create New Invoice");
        NewInv_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewInv_BtnActionPerformed(evt);
            }
        });

        Dele_Inv_Btn.setText("Delete Invoice");
        Dele_Inv_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dele_Inv_BtnActionPerformed(evt);
            }
        });

        NewLine_Btn.setText("Add new line");
        NewLine_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewLine_BtnActionPerformed(evt);
            }
        });

        DeleteLine_Btn.setText("Delete Line");
        DeleteLine_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteLine_BtnActionPerformed(evt);
            }
        });

        jMenuBar1.setMaximumSize(new java.awt.Dimension(50, 32768));

        fileMenu.setText("File");

        LoadItem.setText("Load ");
        LoadItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadItemActionPerformed(evt);
            }
        });
        fileMenu.add(LoadItem);

        MenuItem_save.setText("Save ");
        MenuItem_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_saveActionPerformed(evt);
            }
        });
        fileMenu.add(MenuItem_save);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(76, 76, 76))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addGap(58, 58, 58)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Inv_Total)
                                            .addComponent(Inv_No)
                                            .addComponent(Inv_date, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Inv_name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 63, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(NewInv_Btn)
                        .addGap(69, 69, 69)
                        .addComponent(Dele_Inv_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NewLine_Btn)
                        .addGap(72, 72, 72)
                        .addComponent(DeleteLine_Btn)
                        .addGap(127, 127, 127)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Inv_No))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Inv_date))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Inv_name))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Inv_Total))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewInv_Btn)
                    .addComponent(Dele_Inv_Btn)
                    .addComponent(NewLine_Btn)
                    .addComponent(DeleteLine_Btn))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoadItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadItemActionPerformed

        All_Invoices.clear();
        LoadSave_Handler.loadFiles(All_Invoices);

        GetTotalPrices();

        perfrom();

        display.DisplayHeaderTable(All_Invoices, HeaderTable);
    }//GEN-LAST:event_LoadItemActionPerformed

    private void GetTotalPrices() {
        for (InvoiceHeader invoice : All_Invoices.values()) {
            invoice.TotalPrices();
        }
    }

    private void MenuItem_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem_saveActionPerformed
        LoadSave_Handler.Save_File(All_Invoices);
      JOptionPane.showMessageDialog(null, "Saved Done!", "Sales Invoice Generator Project", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_MenuItem_saveActionPerformed

    private void HeaderTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderTableMouseReleased
        // TODO add your handling code here:
        DisplayRow((int) HeaderTable.getValueAt(HeaderTable.getSelectedRow(), 0));
    }//GEN-LAST:event_HeaderTableMouseReleased

    private void NewInv_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewInv_BtnActionPerformed
        // TODO add your handling code here:
        NewInvoice_Handler.AddNewInvoice(All_Invoices, HeaderTable);
    }//GEN-LAST:event_NewInv_BtnActionPerformed

    private void Dele_Inv_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dele_Inv_BtnActionPerformed
        // TODO add your handling code here:
        int key = (int) HeaderTable.getValueAt(HeaderTable.getSelectedRow(), 0);
        DeleteInvoice_Handler.DeleteInvoice(HeaderTable, All_Invoices, key);
        perfrom();
    }//GEN-LAST:event_Dele_Inv_BtnActionPerformed

    private void NewLine_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewLine_BtnActionPerformed
        int key = Integer.parseInt(Inv_No.getText());
        NewLine_Handler.AddNew_Line(LineTable, key);

        UpdateTables();


    }//GEN-LAST:event_NewLine_BtnActionPerformed

    private void UpdateTables() throws HeadlessException {

        String index_str = Inv_No.getText();
        int index = Integer.parseInt(index_str);

        String date = Inv_date.getText();

        String CustomerName = Inv_name.getText();

        ArrayList<InvoiceLine> Lines = new ArrayList<>();

        DefaultTableModel model = (DefaultTableModel) LineTable.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {

            String name_item = String.valueOf(LineTable.getValueAt(i, 1));

            String price_item_str = String.valueOf(LineTable.getValueAt(i, 2));
            double price_item = Double.parseDouble(price_item_str);

            String count_item_str = String.valueOf(LineTable.getValueAt(i, 3));
            int count_item = Integer.parseInt(count_item_str);

            InvoiceLine InvoiceLines = new InvoiceLine(index, name_item, price_item, count_item);

            Lines.add(InvoiceLines);

            Object obj = new Object();

            obj = InvoiceLines.getTotalPrice();

            LineTable.setValueAt(obj, i, 4);
        }

        All_Invoices.get(index).setName(CustomerName);
        All_Invoices.get(index).setDate(date);
        All_Invoices.get(index).setInvoice_Lines(Lines);
        All_Invoices.get(index).TotalPrices();
        Inv_Total.setText(String.valueOf(All_Invoices.get(index).getTotal()));

        display.DisplayHeaderTable(All_Invoices, HeaderTable);

    }

    private void DeleteLine_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteLine_BtnActionPerformed
int key = (int) LineTable.getValueAt(LineTable.getSelectedRow(), 0);

        InvoiceHeader Inv = All_Invoices.get(key);
        //System.out.print(Inv.getInv_Num());
        ArrayList<InvoiceLine> invline = Inv.getInvoice_Lines();
        invline.remove(LineTable.getValueAt(LineTable.getSelectedRow(), 1));

        DefaultTableModel model = (DefaultTableModel) LineTable.getModel();
       // System.out.println(key);
//       model.removeRow(key);
       // model.removeRow(key);
            model.removeRow(LineTable.getSelectedRow());


        UpdateTables();




    }//GEN-LAST:event_DeleteLine_BtnActionPerformed

    private void DisplayRow(int key) {
        InvoiceHeader invHeader = DisplayOn_Form(key);

        DefaultTableModel model = (DefaultTableModel) LineTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (InvoiceLine InvoiceLine : invHeader.getInvoice_Lines()) {
            row[0] = InvoiceLine.getInv_Num();
            row[1] = InvoiceLine.getItem_Name();
            row[2] = InvoiceLine.getPrice();
            row[3] = InvoiceLine.getItem_count();
            row[4] = InvoiceLine.getTotalPrice();
            model.addRow(row);
        }

    }

    private InvoiceHeader DisplayOn_Form(int key) {
        InvoiceHeader invoice = All_Invoices.get(key);
        Inv_No.setText(String.valueOf(invoice.getInv_Num()));
        Inv_name.setText(invoice.getName());
        Inv_date.setText(invoice.getDate());
        Inv_Total.setText(String.valueOf(invoice.getTotal()));
        return invoice;
    }

    private void perfrom() {
        Inv_No.setText("0");
        Inv_name.setText("");
        Inv_date.setText("");
        Inv_Total.setText("0");
        DefaultTableModel model = (DefaultTableModel) LineTable.getModel();
        model.setRowCount(0);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dele_Inv_Btn;
    private javax.swing.JButton DeleteLine_Btn;
    private javax.swing.JTable HeaderTable;
    private javax.swing.JLabel Inv_No;
    private javax.swing.JLabel Inv_Total;
    private javax.swing.JLabel Inv_date;
    private javax.swing.JLabel Inv_name;
    private javax.swing.JTable LineTable;
    private javax.swing.JMenuItem LoadItem;
    private javax.swing.JMenuItem MenuItem_save;
    private javax.swing.JButton NewInv_Btn;
    private javax.swing.JButton NewLine_Btn;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
