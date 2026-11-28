package com.smartChain.database;

import com.smartChain.model.Product;
import com.smartChain.storage.MySQLProductStorage;

import java.util.HashMap;

public class InsertProductTest {

    static void main(String[] args) {
        Product product = new Product(107,"Washing Machine","Home Appliance",16000,12);

        HashMap<Integer, Product> products = new HashMap<>();
        products.put(product.getId(),product);

        MySQLProductStorage storage = new MySQLProductStorage();
        storage.addProduct(product);

        System.out.println("Inserted test completed");
    }
}
