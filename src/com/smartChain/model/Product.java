package com.smartChain.model;

public class Product {
    private int id;
    private String name;
    private String category;
    private int price;
    private int quantity;

    public Product(int id, String name, String category, int price, int quantity){

        if(id<=0){
            throw new IllegalArgumentException("Product ID must be +ve...");
        }
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Product name Cannot be Empty...");
        }
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative...");
        }
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be negative...");
        }
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getInventoryValue(){
        return price * quantity ;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
