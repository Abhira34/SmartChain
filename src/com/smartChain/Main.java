package com.smartChain;

import com.smartChain.service.ProductManager;

public class Main {
    static {
        System.out.println("************  SMART CHAIN INVENTORY  *************");
        System.out.println("--------------------------------------------------");

    }
    static void main(String[] args) {

        ProductManager manager = new ProductManager();
        manager.loadProducts();

        // ADD Product

        /*
        manager.addProduct( new Product(101,"Rice","Grocery",500,20));
        manager.addProduct(new Product(102,"Cooking Oil","Grocery",150,40));
        manager.addProduct(new Product (103,"Milk","Grocery",65,20));
        manager.addProduct(new Product (104,"Wheat","Grocery",35,50));
        manager.addProduct(new Product (105,"Massor Daal","Grocery",50,60));
        manager.addProduct(new Product(106,"Salt","Grocery",18,6));
       */

       /*

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
        */

        /*
        Product p1 = new Product(107,"Laptop","Electronics",50000,10);
        Product p2 = new Product(108,"Washing Machine","Home Appliance",15000,15);
        manager.addProduct(p1);
        manager.addProduct(p2);
        Product found = manager.searchProductById(107);
        if(found != null){
            System.out.println("Found: "+found.getName());
        }
        manager.displayProducts();
        manager.updateQuantity(107,13);
        manager.sellProduct(108,7);
        Product found2 = manager.searchProductById(107);
        if(found != null){
            System.out.println(found2.getId()+" | "+found2.getName()+" | "+found2.getQuantity()+" | "+found2.getPrice());
        }

       */


        manager.displayProducts();




    }
}