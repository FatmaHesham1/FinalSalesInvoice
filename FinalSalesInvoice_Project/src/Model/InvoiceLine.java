/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class InvoiceLine {
    private int Inv_Num;
    private String Item_Name;
    private double price;
    private int Item_count;
    private double TotalPrice;

    public InvoiceLine(int Inv_Num, String Item_Name, double price, int Item_count) {
        this.Inv_Num = Inv_Num;
        this.Item_Name = Item_Name;
        this.price = price;
        this.Item_count = Item_count;
        Calc_Price();
    }

    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItem_count(int Item_count) {
        this.Item_count = Item_count;
    }

    public int getInv_Num() {
        return Inv_Num;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public double getPrice() {
        return price;
    }

    public int getItem_count() {
        return Item_count;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }
    
    private void Calc_Price(){
        TotalPrice = price*Item_count;
    }
    
}
