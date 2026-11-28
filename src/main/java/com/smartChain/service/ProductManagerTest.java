package com.smartChain.service;

import com.smartChain.model.Product;
import com.smartChain.storage.MySQLProductStorage;
import com.smartChain.storage.ProductStorage;

import java.util.List;

public class ProductManagerTest {

    static void main(String[] args) {
        ProductManager manager = new ProductManager(new MySQLProductStorage());

        System.out.println("======= ALL PRODUCTS =======");

        List<Product> products = manager.getAllProducts();

        for(Product product : products){
            System.out.println(product.getId()+"|"+product.getName()+"|"+product.getCategory()+"|"+product.getPrice()+"|"+product.getQuantity());
        }

        System.out.println("========= Find Product ========");
        Product product = manager.getProductById(103);
        if(product!=null){
            System.out.println(product.getId()+"|"+product.getName()+"|"+product.getPrice());

        }
        else{
            System.out.println("Product Not Found....");
        }
    }
}
