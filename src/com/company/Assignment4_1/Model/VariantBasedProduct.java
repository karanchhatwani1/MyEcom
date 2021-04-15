package com.company.Assignment4_1.Model;

import java.util.List;

public class VariantBasedProduct extends Product{

    List<Variants> variants;

    //we have to make this constructor so as to call the constructor of parent class to save the information of parent class as well.
    public VariantBasedProduct(String name, String imageUrl, List<Variants> variants) {
        super(name, imageUrl);
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "VariantBasedProduct{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", variants=" + variants +
                '}';
    }
}
