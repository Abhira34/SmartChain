package com.smartChain;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    // CREATE
    public void addProduct(Product product){
        if(searchProductById(product.getId()) != null){
            throw new IllegalArgumentException("Product ID Already Exists....");
        }
        products.add(product);
        System.out.println("Product Added Successfully!!!!");
    }

    // DISPLAY / READ
    public void displayProducts(){
        for (Product product : products){
            System.out.println(product.getId()+" | "+product.getName()+" | ₹"+product.getPrice()+" | "+product.getQuantity());
        }
    }

    // SEARCH
    public Product searchProductById(long id){
        for(Product product : products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    // UPDATE
    public boolean updateQuantity(long id, int quantity){
        Product product = searchProductById(id);
        if(product != null){
            product.setQuantity(quantity);
             return true;
        }
        return false ;
    }

    // DELETE
    public boolean deleteProduct(long id){
        Product product = searchProductById(id);
        if(product != null){
            products.remove(product);
            return true ;
        }
        return false ;
    }
}
