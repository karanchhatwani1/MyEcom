package com.company.Assignment4_2.Model;

import com.company.Assignment4_1.Model.Variants;

import java.util.HashMap;

public class Cart {
    public HashMap<String, CartItem> cartItem = new HashMap<>();
    float total;
    int noOfItems;

    //adding weight based product
    public void add(Product product,float quantity){

        //if the item already exist in the cart
        if(cartItem.containsKey(product.name)){
            total = total - cartItem.get(product.name).cost();
            cartItem.get(product.name).quantity = quantity;
            total += product.pricePerKg*quantity;
        }

        //adding for the first time
        else{
            CartItem item = new CartItem(product.name, product.pricePerKg,quantity);
            cartItem.put(product.name, item);
            noOfItems++;
            total += item.cost();
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItem=" + cartItem +
                ", total=" + total +
                ", noOfItems=" + noOfItems +
                '}';
    }

    //adding variant based product
    public void add(Product product, Variants variant){

        String key = product.name + variant.amount;

        //already exist
        if (cartItem.containsKey(key)) {

            //total -= cartItem.get(key).cost();
            cartItem.get(key).quantity++;
            //total -= cartItem.get(key).cost();

        }
        //adding for the first time
        else{
            CartItem item = new CartItem(product.name, variant.price,1);
            cartItem.put(key,item);
        }
        noOfItems++;
        total += variant.price;
    }

    //removing weight based product
    public void removeAll(Product product){

        if(product.type == ProductType.TYPE_WB) {
            removeWBP(product);
        }
        else{
            removeAllVariantsOfVBP(product);
        }

    }

    private void removeWBP(Product product) {
        //Update cart summary
        total -= cartItem.get(product.name).cost();
        noOfItems--;

        //removing cart item
        cartItem.remove(product.name);
    }

    //removing variant based product(complete removal)
    public void removeAllVariantsOfVBP(Product product){
        for(Variants variants : product.variantsList){
            String key = product.name + variants.amount;

            if(cartItem.containsKey(key)){

                //Update cart summary
                total -= cartItem.get(key).cost();
                noOfItems -=cartItem.get(key).quantity;

                //removing cart item
                cartItem.remove(key);
            }
        }
    }

    //Decrement quantity
    public void decrement(Product product, Variants variants){
        String key = product.name + variants.amount;

        //update quantity in cartItem
        cartItem.get(key).quantity--;

        //Update cart summary
        total -= variants.price;
        noOfItems --;

        if(cartItem.get(key).quantity == 0){
            cartItem.remove(key);
        }
    }

}
