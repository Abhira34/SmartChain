package com.smartChain.service;

import com.smartChain.exception.InsufficientStockException;
import com.smartChain.exception.ProductNotFoundException;
import com.smartChain.model.Product;
import com.smartChain.storage.ProductStorage;


import java.util.List;

public class ProductManager {


    private final ProductStorage storage;

    public ProductManager(ProductStorage storage) {
        this.storage = storage;
    }


    // CREATE
    public void addProduct(Product product){
        storage.addProduct(product);
        System.out.println("\nProduct Added Successfully!!!!");

    }

    // SEARCH By ID
    public Product getProductById(int id){
        return storage.getProductById(id);
    }

    // DISPLAY All Product
    public List<Product> getAllProducts(){
        return storage.getAllProduct();
    }

    // UPDATE
    public void updateProduct(Product product){
        if(product != null){
           storage.updateProduct(product);
            System.out.println("\nProduct Updated Successfully... ");
        }else {
            throw new IllegalArgumentException("Product Not Found...");
        }

    }

    // DELETE
    public void deleteProduct(int id){
        storage.deleteProduct(id);
        System.out.println("\nProduct Deleted Successfully...");
    }

    // Sell Product
    public void sellProduct(int productID , int quantity){
        Product product = getProductById(productID);
        if(product.getQuantity() >= quantity){
            int count = product.getQuantity() - quantity ;
            product.setQuantity(count);
            System.out.println("\nThank You!! Continue Your Shopping... ");
            //saveproducts();
        }
        else if (product.getQuantity()<quantity && product.getQuantity()>0) {
            System.out.println("\nAvailable Stock of this Product ID "+productID+"is "+product.getQuantity()+", Request to you make your order in the available quantity range");

        } else{
            throw new InsufficientStockException("\n Sorry!! This Product ID "+productID+" is Out Of Stock...");
        }

    }







}
