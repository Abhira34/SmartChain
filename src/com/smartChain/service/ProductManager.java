package com.smartChain.service;

import com.smartChain.exception.InsufficientStockException;
import com.smartChain.exception.ProductNotFoundException;
import com.smartChain.model.Product;

import java.util.HashMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.util.Map;

public class ProductManager {
    private HashMap<Integer,Product> products = new HashMap<>();

    // CREATE
    public void addProduct(Product product){
        if(products.containsKey(product.getId())){
            throw new IllegalArgumentException("Product ID Already Exists....");
        }
        products.put(product.getId(),product);
        System.out.println("Product Added Successfully!!!!");
        saveproducts();
    }

    // DISPLAY / READ
    public void displayProducts(){
        for (Product product : products.values()){
            System.out.println(product.getId()+" | "+product.getName()+" | ₹"+product.getPrice()+" | "+product.getQuantity());
        }
    }

    // SEARCH
    public Product searchProductById(int id){
        if(products.containsKey(id)){
                return products.get(id);
        }
        else {
            throw new ProductNotFoundException("Product with ID "+id+" was not found.");
        }
    }

    // UPDATE
    public void updateQuantity(int id, int quantity){
        Product product = searchProductById(id);
        if(product != null){
            product.setQuantity(quantity);
            System.out.println("\nQuantity Updated Successfully... ");
            saveproducts();
        }else {
            throw new IllegalArgumentException("Product Not Found...");
        }

    }

    // DELETE
    public void deleteProduct(int id){
       if(!products.containsKey(id)){
           throw new IllegalArgumentException("Product Not Found...");
       }
        products.remove(id);
        System.out.println("\nProduct Deleted Successfully...");
        saveproducts();
    }

    // Sell Product
    public void sellProduct(int productID , int quantity){
        Product product = searchProductById(productID);
           if(product.getQuantity() >= quantity){
               int count = product.getQuantity() - quantity ;
               product.setQuantity(count);
               System.out.println("\nThank You!! Continue Your Shopping... ");
               saveproducts();
           }
           else if (product.getQuantity()<quantity && product.getQuantity()>0) {
               System.out.println("\nAvailable Stock of this Product ID "+productID+"is "+product.getQuantity()+", Request to you make your order in the available quantity range");

           } else{
               throw new InsufficientStockException("\n Sorry!! This Product ID "+productID+" is Out Of Stock...");
           }

    }

    // Save Product
    public void saveproducts(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"))){
            for(Product product : products.values()){

                String data =
                        product.getId()+"|"+product.getName()+"|"+product.getCategory()+"|"+product.getPrice()+"|"+product.getQuantity();
                writer.write(data);
                writer.newLine();
            }
            System.out.println("Products Saved Successfully");
        } catch (IOException e){
            System.out.println("Error Saving Products: "+e.getMessage());
        }
    }

    // Load Product
    public void loadProducts(){

        File file = new File("products.txt");

        if(!file.exists()){
            System.out.println("No previous product data found. Starting Fresh..");
            return ;
        }

        products.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            String line;
            while((line = reader.readLine()) != null){

                String[] data = line.split("\\|", -1);
                if(data.length !=5){
                    System.out.println("Invalid Product Record: "+line);
                    continue;
                }
                try{
                   int id = Integer.parseInt(data[0]);
                   String name = data[1];
                   String category = data[2];
                   int price = Integer.parseInt(data[3]);
                   int quantity = Integer.parseInt(data[4]);

                   if(products.containsKey(id)){
                        System.out.println("Duplicate product ID: "+id);
                        continue;
                   }

                   Product product = new Product(id, name,category,price,quantity);
                   products.put(id,product);
                } catch (IllegalArgumentException e){
                    System.out.println("Skipping Invalid Record: "+line);
                }
            }
            System.out.println("Products Loaded Successfully...");
        } catch (IOException e){
            System.out.println("Error Loading Products: "+e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Product Data_1: " + e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Invalid Product Data: "+e.getMessage());
        }
    }





}
