package com.smartChain.storage;

import com.smartChain.model.Product;
import java.util.List;

public interface ProductStorage {

    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProduct();

    void updateProduct(Product product);

    void deleteProduct(int id);

}
