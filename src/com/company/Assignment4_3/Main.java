package com.company.Assignment4_3;

import com.company.Assignment4_2.Model.Cart;
import com.company.Assignment4_2.Model.CartItem;
import com.company.Assignment4_2.Model.Product;
import com.company.Assignment4_1.Model.Variants;
import com.company.Assignment4_2.Model.ProductType;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int choice;
        char decision;
        String productName,imageURL;

        HashMap<String, Product> products = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("** WELCOME TO MYECOM **");
        System.out.println("\nYou have the following options - ");

        System.out.println("\n1. Press 0 if you want to add a product to the product list.");
        System.out.println("2. Press 1 if you want to edit any existing product in the list.");
        System.out.println("3. Press 2 if you want to delete a product.");
        System.out.println();
        System.out.println("Checking cart details - ");
        System.out.println("4. Press 3 if you want to add an element in the cart.");
        System.out.println("5. Press 4 if you want to remove an element from the cart.");
        System.out.println("6. Press 5 if you want to edit an element from the cart.");
        System.out.println("7. Press 6 if you want to have a look on the cart items.");
        System.out.println("8. Enter 7 if you want to exit the application.");
        System.out.println();
        System.out.println("Now You May Proceed");
        System.out.println("Enter you choice - ");
        choice = sc.nextInt();

        while(choice != 7){

            switch (choice){
                case 0:
                    add(products);
                    break;
                case 1:
                    editProduct(products);
                    break;

                case 2 :
                    System.out.println("Enter the name of the product you want to delete - ");
                    productName = sc.next();
                    if(products.containsKey(productName)){
                        products.remove(productName);
                        System.out.println("Deleted Successfully");
                    }
                    else{
                        System.out.println("The entered product is not in the list");
                    }
                    break;

                case 3:
                    Cart cart = new Cart();
                    addToCart(products,cart);
                    break;

                case 4:
                    System.out.println("Enter the productName you want to remove - ");
                    productName = sc.next();
                    Cart cart1 = new Cart();
                    cart1.removeAll(products.get(productName));
                    System.out.println("Your product have been successfully removed");
                    break;

                case 5:
                    editCrtItem(products);
                    break;

                case 6:
                    System.out.println("Have a look at your cart : ");
                    cart = new Cart();
                    if(cart.cartItem.isEmpty()){
                        System.out.println("Cart is empty");
                    }
                    for (Map.Entry<String, CartItem> set : cart.cartItem.entrySet()){
                        System.out.println(set.getValue());
                    }
                    break;

                default:
                    System.out.println("Enter a valid number!");
            }
            System.out.println("Enter you choice - ");
            choice = sc.nextInt();
        }
        System.out.println("Thank you for installing our app!");
    }

    private static void addToCart(HashMap<String, Product> products,Cart cart) {
        Scanner sc = new Scanner(System.in);
        String productName,imageURL;
        float quantity;

        System.out.println("Enter the product name you want to add in the cart - ");
        productName = sc.next();

        if(!products.containsKey(productName)){
            System.out.println("Entered product is unavailable");
        }
        else if(products.get(productName).type == ProductType.TYPE_WB){
            System.out.println("Enter the quantity you want to add");
            quantity = sc.nextFloat();
            cart.add(products.get(productName),quantity);
            System.out.println("Your product have been successfully added");
        }
        else if(products.get(productName).type == ProductType.TYPE_VB){
            int sNo=0;
            System.out.println("Choose among the following variants - ");
            for(Variants variants : products.get(productName).variantsList){
                System.out.println(sNo + " : " + variants);
                sNo++;
            }
            sNo = sc.nextInt();
            cart.add(products.get(productName),products.get(productName).variantsList.get(sNo));
            System.out.println("Your product have been successfully added");
        }
    }

    private static void editCrtItem(HashMap<String, Product> products) {
        Scanner sc = new Scanner(System.in);
        String productName,imageURL;
        System.out.println("Enter the product name you want to edit - ");
        productName = sc.next();
        if(!products.containsKey(productName)){
            System.out.println("Entered product is unavailable");
        }
        else if(products.get(productName).type == ProductType.TYPE_WB){
            Cart cart2 = new Cart();
            float quantity1;
            System.out.println("Enter the new quantity you want to add - ");
            quantity1 = sc.nextFloat();
            cart2.add(products.get(productName),quantity1);
        }
        else{
            Cart cart2 = new Cart();
            int sNo1=0;
            System.out.println("Choose among the following variants - ");
            for(Variants variants : products.get(productName).variantsList){
                System.out.println(sNo1 + " : " + variants);
                sNo1++;
            }
            sNo1 = sc.nextInt();
            cart2.add(products.get(productName),products.get(productName).variantsList.get(sNo1));
        }
    }

    private static void editProduct(HashMap<String, Product> products) {
        Scanner sc = new Scanner(System.in);
        String productName,imageURL;
        float minQty,pricerPerKg;
        String amount;
        float price;
        int noOfVariants;
        List<Variants> var = new ArrayList<>();

        System.out.println("Enter the product name you want to edit :");
        productName = sc.next();
        String key1 = productName;
        if(!products.containsKey(productName)){
            System.out.println("The product is not present in the list");
        }
        else if(products.get(productName).type ==  ProductType.TYPE_WB){
            System.out.println("Enter new name - ");
            productName = sc.next();
            String key2 = productName;
            System.out.println("Enter new image URL - ");
            imageURL = sc.next();
            System.out.println("Enter new minimum quantity");
            minQty = sc.nextFloat();
            System.out.println("Enter new price per kg");
            pricerPerKg = sc.nextFloat();
            Product product = new Product(productName,imageURL,minQty,pricerPerKg);
            products.put(key2, product);
            System.out.println("Successfully edited");
        }
        else if(products.get(productName).type == ProductType.TYPE_VB){
            System.out.println("Enter new name - ");
            productName = sc.next();
            String key2 = productName;
            System.out.println("Enter new image URL - ");
            imageURL = sc.next();
            System.out.println("Enter new no of variants - ");
            noOfVariants = sc.nextInt();
            System.out.println("Enter new variants - ");
            for(int i=0;i<noOfVariants;i++){
                amount = sc.next();
                price = sc.nextFloat();
                Variants variants = new Variants(amount,price);
                var.add(variants);
            }
            Product product = new Product(productName,imageURL,var);
            products.put(key2,product);
            System.out.println("Successfully edited");
        }
        else{
            System.out.println("Invalid product");
        }
        products.remove(key1);
    }

    private static void add(HashMap<String, Product> products) {
        Scanner sc = new Scanner(System.in);
        char type;
        String productName,imageURL;
        float minQty,pricerPerKg;
        String amount;
        float price;
        int noOfVariants;
        List<Variants> var = new ArrayList<>();

        System.out.println("Enter W if your product is weight based or \nEnter V if your product is variant based :");
        type = sc.next().charAt(0);
        if(type == 'W'){
            System.out.println("Enter the name of the product you want to add :");
            productName = sc.next();
            System.out.println("Enter image URL :");
            imageURL = sc.next();
            System.out.println("Enter minimum quantity :");
            minQty = sc.nextFloat();
            System.out.println("Enter price per kg :");
            pricerPerKg = sc.nextFloat();
            Product product1 = new Product(productName,imageURL,minQty,pricerPerKg);
            products.put(productName, product1);
            System.out.println("Your product is successfully added");
        }
        else if(type == 'V'){
            System.out.println("Enter the name of the product you want to add :");
            productName = sc.next();
            System.out.println("Enter image URL :");
            imageURL = sc.next();
            System.out.println("Enter the number of variants : ");
            noOfVariants  = sc.nextInt();
            System.out.println("Enter the variants : ");
            for(int i=0;i<noOfVariants;i++){
                amount = sc.next();
                price = sc.nextFloat();
                Variants variants = new Variants(amount,price);
                var.add(variants);
            }
            String key = productName;
            Product product2 = new Product(productName,imageURL,var);
            products.put(key, product2);

            System.out.println("Your product is successfully added ");
        }

    }
}
