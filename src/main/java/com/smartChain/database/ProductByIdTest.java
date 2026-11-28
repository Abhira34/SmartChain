package com.smartChain.database;

import com.smartChain.model.Product;
import com.smartChain.storage.MySQLProductStorage;

public class ProductByIdTest {
    static void main(String[] args) {

        MySQLProductStorage storage = new MySQLProductStorage();
        Product product = storage.getProductById(104);
        if(product != null) {
            System.out.println("Product Found: ");
            System.out.println(
                    product.getId()+" | "+
                    product.getName()+" | "+
                    product.getCategory()+" | "+
                    product.getPrice()+" | "+
                    product.getQuantity()
            );
        }
        else{
            System.out.println("Product Not Found...");
        }
    }
}
