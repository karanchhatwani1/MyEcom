package com.company.Assignment4_2;

import com.company.Assignment4_1.Model.Variants;
import com.company.Assignment4_2.Model.Cart;
import com.company.Assignment4_2.Model.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Product apple = new Product("Apple","",1.0f,100)
                ,orange = new Product("Orange","",0.5f,90)
                ,surf = new Product("Surf","",new ArrayList<>(
                Arrays.asList(
                        new Variants("1kg",100)
                        ,new Variants("2kg",200)
                )
        ));

        //adding weight based product
        Cart cart = new Cart();
        cart.add(apple,2);
        cart.add(orange,4);

        //adding variant based product
        cart.add(surf,surf.variantsList.get(0));
        cart.add(surf,surf.variantsList.get(0));
        cart.add(surf,surf.variantsList.get(0));
        cart.add(surf,surf.variantsList.get(1));
        System.out.println(cart);
        System.out.println();

        //removing weight based product
        cart.removeAll(apple);
        System.out.println(cart);
        System.out.println();

        //removing variant based product
        cart.removeAll(surf);
        System.out.println(cart);
        System.out.println();

        //decrementing
        cart.decrement(surf,surf.variantsList.get(0));
        System.out.println(cart);
        System.out.println();
    }
}
