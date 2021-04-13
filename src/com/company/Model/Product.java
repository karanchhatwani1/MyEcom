package com.company.Model;

import java.util.Objects;

public class Product {

    public String name;
    public String imageUrl;

    public Product() {
        name = "karan";
        imageUrl = "aa";
    }

    public Product(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "\nname='" + name + '\'' +
                ", \nimageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    //Object class is a super class of every class
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(imageUrl, product.imageUrl);
    }

    //The hashcode of two different object product class will be different
    //but after overriding this method the hashcode will be same.
    @Override
    public int hashCode() {
        return Objects.hash(name, imageUrl);
    }
}
