/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.InvoiceHeader;
import Model.InvoiceLine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LoadSave_Handler {

    private static File InvoiceHeader_file;
    private static File InvoiceLine_file;
    private static MessageDialog_Handler dialogHandler = new MessageDialog_Handler();

    public static void loadFiles(Map<Integer, InvoiceHeader> invoices) {
        dialogHandler.showDialog("Choose the Header File First", "info");

        while (true) {
            //Get the result file
            JFileChooser FileChooser = new JFileChooser();
            int result = FileChooser.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                InvoiceHeader_file = FileChooser.getSelectedFile();
                try {

                    Check_FileType();
                    FileReader file = new FileReader(InvoiceHeader_file);
                    BufferedReader BufferedHeader = new BufferedReader(file);

                    //Reading the content of the file
                    String line;
                    while ((line = BufferedHeader.readLine()) != null) {
                        
                        String[] row = line.split(",");
                        
                        String inv_Num=row[0];
                        int invoiceNum = Integer.parseInt(inv_Num);

                        String Date = row[1];

                        String Name = row[2];
                        
                        InvoiceHeader InvoiceObj = new InvoiceHeader(invoiceNum, Date, Name);

                        AddToMap(invoices, invoiceNum, InvoiceObj);
                    }
                    BufferedHeader.close();
                    file.close();
                    break;
                } catch (FileNotFoundException e) {
                    dialogHandler.showDialog("Selected File is not found", "error");

                } catch (IOException e) {
                    dialogHandler.showDialog("Try Again", "error");

                } catch (NumberFormatException e) {
                    dialogHandler.showDialog("There is a problem in the file format", "error");

                }
            }
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////
//Line File
        dialogHandler.showDialog("Choose Line File", "info");

        while (true) {
            JFileChooser FileChooser = new JFileChooser();
            int result = FileChooser.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                InvoiceLine_file = FileChooser.getSelectedFile();
                try {
                    Check_FileType();
                    FileReader file = new FileReader(InvoiceLine_file);
                    BufferedReader BufferedLine = new BufferedReader(file);

                    String line;
                    while ((line = BufferedLine.readLine()) != null) {
                        
                        String[] row = line.split(",");
                        
                        String invoiceNum_str = row[0];
                        int invoice_Num = Integer.parseInt(invoiceNum_str);

                        String ItemName = row[1];

                        String price_str = row[2];
                        double price = Double.parseDouble(price_str);

                        String count_str = row[3];
                        int count = Integer.parseInt(count_str);
                        
                        InvoiceLine invItem = new InvoiceLine(invoice_Num, ItemName, price, count);

                        AddLine_ToHeader(invoices, invoice_Num, invItem);
                    }
                    
                    BufferedLine.close();
                    file.close();
                    break;
                } catch (FileNotFoundException e) {
                    
                    dialogHandler.showDialog("Selected File is not found", "error");

                } catch (IOException e) {

                    dialogHandler.showDialog("Try Again", "error");

                } catch (NumberFormatException e) {
                    dialogHandler.showDialog("There is a problem in the file format", "error");

                }
            }
        }
    }

    //Mapping each InvoiceHeader line to the header and add it
    private static void AddLine_ToHeader(Map<Integer, InvoiceHeader> All_invoices, int invoice_Num, InvoiceLine LineObj) {
        All_invoices.get(invoice_Num).AddLine(LineObj);
    }

    //Adding each InvoiceHeader header to the map with the InvoiceHeader number as a key
    private static void AddToMap(Map<Integer, InvoiceHeader> All_Invoices, int invoiceNum, InvoiceHeader HeaderObj) {
        
        All_Invoices.put(invoiceNum, HeaderObj);
        
    }

    //Making sure that the file is .csv file
    private static void Check_FileType() {
        
        if (!InvoiceHeader_file.getName().endsWith(".csv")) {
            dialogHandler.showDialog("Please Select .CSV File!", "error");
        }
        else{
        }
            
    }

    public static void Save_File(Map<Integer, InvoiceHeader> All_Invoices) {
        InvoiceHeader_file.setWritable(true);
        InvoiceLine_file.setWritable(true);
        try {
            FileWriter HeaderFile = new FileWriter(InvoiceHeader_file, false);
            BufferedWriter BufferedHeader = new BufferedWriter(HeaderFile);
            
            FileWriter LineFile = new FileWriter(InvoiceLine_file, false);
            BufferedWriter BufferedLine = new BufferedWriter(LineFile);
            
            Check_FileType();
            
            Save_InvoicesInFile(All_Invoices, BufferedHeader, BufferedLine);
            
            BufferedLine.close();
            LineFile.close();
            
            BufferedHeader.close();
            HeaderFile.close();
            
        } catch (IOException ex) {
                    dialogHandler.showDialog("Try Again", "error");
        } 
        catch (NullPointerException e) {
                    dialogHandler.showDialog("This File is not found", "error");

        }
    }
    
    
    //Iterate the All_Invoices map and get the InvoiceHeader header and file and write them 
    private static void Save_InvoicesInFile(Map<Integer, InvoiceHeader> All_Invoices, BufferedWriter BufferedHeader, BufferedWriter BuffredLine) throws IOException {
       
        for (InvoiceHeader InvoiceHeader : All_Invoices.values()) {
            String header = "" + 
                    InvoiceHeader.getInv_Num() +
                    "," + InvoiceHeader.getDate() +
                    "," + InvoiceHeader.getName() + "\n";
            
            BufferedHeader.write(header);
            
            for (InvoiceLine InvoiceLine : InvoiceHeader.getInvoice_Lines()) {
                String line = "" +
                        InvoiceLine.getInv_Num() + 
                        "," + InvoiceLine.getItem_Name() + 
                        "," + InvoiceLine.getPrice() + 
                        "," + InvoiceLine.getItem_count() + "\n";
                
                BuffredLine.write(line);
            }
        }
    }

}
