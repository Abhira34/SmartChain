package com.smartChain.service;

import com.smartChain.model.Product;

public class Box <T> {

    private T value;
    public void setValue(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }

    static void main(String[] args) {
        Box<String> nameBox = new Box<>();
        nameBox.setValue("SmartChain");
        System.out.println(nameBox.getValue());

        Box<Integer> numberBox = new Box<>();
        numberBox.setValue(147);
        System.out.println(numberBox.getValue());

        Box<Product> productBox = new Box<>();
        Product p1 = new Product(101,"Dove","Soap",35,30);
        productBox.setValue(p1);
        System.out.println(productBox.getValue().getName());

    }
}
