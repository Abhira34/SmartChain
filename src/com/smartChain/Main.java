package com.smartChain;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product(1,"Rice","Grocery",500,20);
        Product p2 = new Product(2,"Cooking Oil","Grocery",150,40);

        products.add(p1);
        products.add(p2);

        for(Product product:products){
            System.out.println(product.getId()+" | "+product.getName()+" | ₹"+product.getPrice());
        }


    }
}