package com.smartChain.service;

import com.smartChain.exception.InsufficientStockException;
import com.smartChain.exception.ProductNotFoundException;
import com.smartChain.model.Product;
import com.smartChain.storage.ProductStorage;

import java.util.HashMap;

public class ProductManager {

    private HashMap<Integer,Product> products ;

    private ProductStorage storage;

    public ProductManager(ProductStorage storage){
        this.storage = storage;
        this.products = storage.loadProducts();
    }

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
        if(products.isEmpty()){
            System.out.println("No products available..");
            return ;
        }
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

    // Save Products
    public void saveproducts(){
        storage.saveProducts(products);
    }






}
