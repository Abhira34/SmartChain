package com.smartChain.database;

import com.smartChain.model.Product;
import com.smartChain.storage.MySQLProductStorage;

import java.util.List;

public class AllProductsTest {

    static void main(String[] args) {
        MySQLProductStorage storage = new MySQLProductStorage();
        List<Product> products = storage.getAllProduct();

        System.out.println(" Products ");
        System.out.println("----------");

        for(Product product : products){
            System.out.println(
                    product.getId() + " | " +
                            product.getName() + " | " +
                            product.getCategory() + " | " +
                            product.getPrice() + " | " +
                            product.getQuantity()
            );
        }
        System.out.println("-----------------------------");
        System.out.println("Total products: " + products.size());
    }
}
