package com.smartChain;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(long id, String name, String category, double price, int quantity){

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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getInventoryValue(){
        return price * quantity ;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
