package com.smartChain;

import com.smartChain.model.Product;
import com.smartChain.service.ProductManager;
import com.smartChain.storage.ProductStorage;
import com.smartChain.storage.FileManager;

public class Main {
    static {
        System.out.println("************  SMART CHAIN INVENTORY  *************");
        System.out.println("--------------------------------------------------");

    }
    static void main(String[] args) {

        ProductStorage storage = new FileManager();
        ProductManager manager = new ProductManager(storage);

        try{
            manager.addProduct( new Product(101,"Rice","Grocery",500,20));
            manager.addProduct(new Product(102,"Cooking Oil","Grocery",150,40));
            manager.addProduct(new Product (103,"Milk","Grocery",65,20));
            manager.addProduct(new Product (104,"Wheat","Grocery",35,50));
            manager.addProduct(new Product (105,"Massor Daal","Grocery",50,60));
            manager.addProduct(new Product(106,"Salt","Grocery",18,6));

            Product p1 = new Product(107,"Laptop","Electronics",50000,10);
            Product p2 = new Product(108,"Washing Machine","Home Appliance",15000,15);

            manager.addProduct(p1);
            manager.addProduct(p2);
        } catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }

        System.out.println("\n-------Products------");
        manager.displayProducts();

        System.out.println("\n-------Search Product------");
        Product found = manager.searchProductById(108);

        if(found != null){
            found.displayDetails();
        } else{
            System.out.println("Products not Found...");
        }

        System.out.println("\n----Saving products----");
        manager.saveproducts();

        System.out.println("\n-----Sell Products------");
        manager.sellProduct(108,7);

        Product found1 = manager.searchProductById(108);

        if(found1 != null){
            found1.displayDetails();
        } else{
            System.out.println("Products not Found...");
        }

//        manager.displayProducts();


//        Product p3 = new Product(109,"Dove","Soap",80,30);
//        ApiResponse<Product> response = new ApiResponse<>(
//                true,"Product FOund Successfully",p3
//        );
//        System.out.println(response.getMessage());
//        System.out.println(response.getData().getName());



    }
}