package com.company.Model;

public class Variants {

    String name;
    float price;

    public Variants(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Variants{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
