package com.company.Assignment4_2.Model;

public class Variants {

    String amount;
    float price;

    public Variants(String amount, float price) {
        this.amount = amount;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Variants{" +
                "amount='" + amount + '\'' +
                ", price=" + price +
                '}';
    }
}
