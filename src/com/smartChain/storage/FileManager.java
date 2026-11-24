package com.smartChain.storage;

import com.smartChain.model.Product;

import java.io.*;
import java.util.HashMap;

public class FileManager implements ProductStorage {
    private final String fileName = "products.txt";


    @Override
    public void saveProducts(HashMap<Integer, Product> products) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for(Product product : products.values()){

                String data =
                        product.getId()+" | "+product.getName()+ " | "+product.getCategory()+" | "+product.getPrice()+" | "+product.getQuantity();
                writer.write(data);
                writer.newLine();
            }
            System.out.println("\nProducts Saved Successfully....");
        } catch (IOException e){
            System.out.println("\nError Saving Products: "+e.getMessage());
        }
    }

    @Override
    // Load Product
    public HashMap<Integer, Product> loadProducts(){

        HashMap<Integer, Product> products = new HashMap<>();
        File file = new File(fileName);

        if(!file.exists()){
            System.out.println("\nNo previous product data found. Starting Fresh..");
            return products;
        }

        products.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){

            String line;
            while((line = reader.readLine()) != null){

                if(line.trim().isEmpty()){
                    continue;
                }
                String[] data = line.split("\\|", -1);
                if(data.length !=5){
                    System.out.println("\nInvalid Product Record: "+line);
                    continue;
                }
                try{
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String category = data[2];
                    int price = Integer.parseInt(data[3]);
                    int quantity = Integer.parseInt(data[4]);

                    if(products.containsKey(id)){
                        System.out.println("\nDuplicate product ID: "+id);
                        continue;
                    }

                    Product product = new Product(id, name,category,price,quantity);
                    products.put(id,product);
                } catch (IllegalArgumentException e){
                    System.out.println("\nSkipping Invalid Record: "+line);
                }
            }
            System.out.println("\nProducts Loaded Successfully...");
        } catch (IOException e){
            System.out.println("\nError Loading Products: "+e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid Product Data_1: " + e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("\nInvalid Product Data: "+e.getMessage());
        }
        return products;
    }
}
