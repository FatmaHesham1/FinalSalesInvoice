/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class InvoiceHeader {

    public static int counter = 1;
    private final int Inv_Num;
    private String date;
    private String name;
    private double total;
    private ArrayList<InvoiceLine> invoice_Lines;

    public InvoiceHeader(String date, String name) {
        Inv_Num = counter++;
        this.date = date;
        this.name = name;
        invoice_Lines = new ArrayList<>();
    }

    public InvoiceHeader(int Inv_Num, String date, String name) {
        this.Inv_Num = Inv_Num;
        counter = Inv_Num + 1;
        this.date = date;
        this.name = name;
        invoice_Lines = new ArrayList<>();
    }

    public int getInv_Num() {
        return Inv_Num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<InvoiceLine> getInvoice_Lines() {
        return invoice_Lines;
    }

    public void setInvoice_Lines(ArrayList<InvoiceLine> invoice_Lines) {
        this.invoice_Lines = invoice_Lines;
    }

    public void TotalPrices() {
        
        total = 0;
        for (int i = 0; i < invoice_Lines.size(); i++) {
            total += invoice_Lines.get(i).getTotalPrice();
        }
    }

    public void AddLine(InvoiceLine line) {
        invoice_Lines.add(line);
    }

}
