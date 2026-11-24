package com.smartChain.storage;

import com.smartChain.model.Product;
import java.util.HashMap;

public interface ProductStorage {

    void saveProducts(HashMap<Integer,Product> products);
    HashMap<Integer, Product> loadProducts();

}
