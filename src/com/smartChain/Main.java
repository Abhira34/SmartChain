package com.smartChain;

import java.util.ArrayList;

public class Main {
    static {
        System.out.println("************  SMART CHAIN INVENTORY  *************");
        System.out.println("--------------------------------------------------");

    }
    static void main(String[] args) {

        // ADD Product
        ProductManager manager = new ProductManager();
        manager.addProduct( new Product(101,"Rice","Grocery",500,20));
        manager.addProduct(new Product(102,"Cooking Oil","Grocery",150,40));
        manager.addProduct(new Product (103,"Milk","Grocery",65,20));
        manager.addProduct(new Product (104,"Wheat","Grocery",35,50));
        manager.addProduct(new Product (105,"Massor Daal","Grocery",50,60));
        manager.addProduct(new Product(106,"Salt","Grocery",18,6));

        // DISPLAY Product
        System.out.println("\nAll Product");
        manager.displayProducts();

        // SEARCH Product
        Product result = manager.searchProductById(345);
        if(result != null){
            System.out.println("\nFound: "+result.getName());
        }
        else{
            System.out.println("\nProduct ID is Invalid!!!");
        }

        // UPDATE
        manager.updateQuantity(6,30);

        // DELETE
        manager.deleteProduct(10);

        System.out.println("\n After Update and Delete");
        manager.displayProducts();

        try{
            Product invalidProduct = new Product(111,"SurfExcel","Detergent",90,80);
            manager.addProduct(invalidProduct);
        }
        catch(IllegalArgumentException e){
            System.out.println("\nValidation Error: "+e.getMessage());
        }
    }
}