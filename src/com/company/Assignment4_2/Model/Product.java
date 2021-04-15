package com.company.Assignment4_2.Model;

import com.company.Assignment4_1.Model.Variants;

import java.util.List;

public class Product {

    //Common attributes
    public String name,imageURL;
    public int type;


    //WeightBased attributes
    float minQty,pricePerKg;

    //Variants attribute
    public List<Variants> variantsList;

    //Constructor for WB
    public Product(String name, String imageURL, float minQty, float pricePerKg) {
        type = ProductType.TYPE_WB;
        this.name = name;
        this.imageURL = imageURL;
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    //Constructor for VB
    public Product(String name, String imageURL,List<Variants> variantsList) {
        type = ProductType.TYPE_VB;
        this.name = name;
        this.imageURL = imageURL;
        this.variantsList = variantsList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if(type == ProductType.TYPE_WB){
            builder.append("WB { ");
        }
        else{
            builder.append("VB { ");
        }
        builder.append("name = ").append(name);

        if(type == ProductType.TYPE_WB){
            builder.append("minQty = ").append(minQty);
            builder.append(",PricePerKg = ").append(pricePerKg);
        }
        else{
            builder.append(" variants = ").append(variantsList);
        }
        builder.append(" } ");

        return builder.toString();
    }
}
