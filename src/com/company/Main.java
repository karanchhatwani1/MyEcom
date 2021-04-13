package com.company;

import com.company.Model.Product;
import com.company.Model.VariantBasedProduct;
import com.company.Model.Variants;
import com.company.Model.WeightBasedProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Variants> variantsList = new ArrayList<>(
                Arrays.asList(new Variants("500",90),
                              new Variants("600",100)));

	    //if we don't pass parameter it will give null or give the default value we have written in the empty constructor
        Product product = new Product();
        System.out.println(product);

        //if we pass parameter then it will run to string when we try to print it
        Product product1 = new Product("Apple","kc");
        System.out.println(product1);

        WeightBasedProduct weightBasedProduct = new WeightBasedProduct("Apple","",110.0f,20.0f);
        System.out.println(weightBasedProduct);

        VariantBasedProduct variantBasedProduct = new VariantBasedProduct("Surf","", variantsList);
        //We have to call to string method in variant class as well to print the list.
        System.out.println(variantBasedProduct);
    }
}
