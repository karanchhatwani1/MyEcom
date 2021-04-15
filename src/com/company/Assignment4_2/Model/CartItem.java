package com.company.Assignment4_2.Model;

public class CartItem {

    String name;
    float unitPrice,quantity;

    @Override
    public String toString() {
        return "CartItem{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }

    float cost(){
        return unitPrice*quantity;
    }

    public CartItem(String name, float unitPrice, float quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
}
