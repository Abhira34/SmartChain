package com.smartChain;

import com.smartChain.model.Product;
import com.smartChain.service.ProductManager;
import com.smartChain.storage.ProductStorage;
import com.smartChain.storage.FileManager;
import com.smartChain.storage.MySQLProductStorage;

import java.util.List;
import java.util.Scanner;

public class Main {

    static {
        System.out.println(" -------------------------------------------------- ");
        System.out.println(" ************  SMART CHAIN INVENTORY  ************* ");
        System.out.println(" -------------------------------------------------- ");

    }

    static void main(String[] args) {

        ProductStorage storage = new MySQLProductStorage();
        ProductManager manager = new ProductManager(storage);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running){
            System.out.println();
            System.out.println(" 1. Add Product ");
            System.out.println(" 2. View All Product ");
            System.out.println(" 3. Find Product ");
            System.out.println(" 4. Update Product ");
            System.out.println(" 5. Delete Product ");
            System.out.println(" 6. Exit ");
            System.out.println("\nChoose An Operation Which you Want To Perform...");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

                case 1 -> {
                    System.out.println();

                    System.out.println("Enter ID:- ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Name:- ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Category:- ");
                    String category = scanner.nextLine();

                    System.out.println("Enter Price:- ");
                    int price = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Quantity:- ");
                    int quantity = scanner.nextInt();

                    Product product = new Product (id, name, category, price, quantity);
                    manager.addProduct(product);
                }

                case 2 -> {
                    List<Product> products = manager.getAllProducts();

                    System.out.println("\n====== Products ======");

                    for(Product product : products){
                        System.out.println(
                                product.getId()+" | "+
                                product.getName()+" | "+
                                product.getCategory()+" | "+
                                product.getPrice()+" | "+
                                product.getQuantity()
                        );
                    }
                }

                case 3 -> {
                    System.out.println();

                    System.out.println("Enter Product ID:- ");
                    int id = scanner.nextInt();

                    Product product = storage.getProductById(id);

                    if(product != null){
                        System.out.println(
                                product.getId()+" | "+
                                product.getName()+" | "+
                                product.getCategory()+" | "+
                                product.getPrice()+" | "+
                                product.getQuantity()
                        );
                    }
                    else
                    {
                        System.out.println("\nProduct Not Found!!!");
                    }
                }

                case 4 -> {
                    System.out.println();

                    System.out.println("Enter Product ID:- ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter New Name:- ");
                    String name = scanner.nextLine();

                    System.out.println("Enter New Category:- ");
                    String category = scanner.nextLine();

                    System.out.println("Enter New Price:- ");
                    int price = scanner.nextInt();

                    System.out.println("Enter New Quantity:- ");
                    int quantity = scanner.nextInt();

                    Product product = new Product (id,name,category,price,quantity);

                    manager.updateProduct(product);
                }

                case 5 -> {
                    System.out.println();

                    System.out.println("Enter Product ID to Delete:- ");
                    int id = scanner.nextInt();

                    manager.deleteProduct(id);
                }

                case 6 -> {
                    running = false;
                    System.out.println();
                    System.out.println("Exiting From Smart Chain Inventory");
                }

                default -> {
                    System.out.println("Choose Valid Option...");
                }
            }
        }
        scanner.close();










        /*

       try {
            manager.addProduct(new Product(101, "Rice", "Grocery", 500, 20));
            manager.addProduct(new Product(102, "Cooking Oil", "Grocery", 150, 40));
            manager.addProduct(new Product(103, "Milk", "Grocery", 65, 20));
            manager.addProduct(new Product(104, "Wheat", "Grocery", 35, 50));
            manager.addProduct(new Product(105, "Massor Daal", "Grocery", 50, 60));
            manager.addProduct(new Product(106, "Salt", "Grocery", 18, 6));

            Product p1 = new Product(107, "Laptop", "Electronics", 50000, 10);
            Product p2 = new Product(108, "Washing Machine", "Home Appliance", 15000, 15);

            manager.addProduct(p1);
            manager.addProduct(p2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n-------Products------");
        manager.displayProducts();

        System.out.println("\n-------Search Product------");
        Product found = manager.searchProductById(108);

        if (found != null) {
            found.displayDetails();
        } else {
            System.out.println("Products not Found...");
        }

        System.out.println("\n----Saving products----");
        //manager.saveproducts();

        System.out.println("\n-----Sell Products------");
        manager.sellProduct(108, 7);

        Product found1 = manager.searchProductById(108);

        if (found1 != null) {
            found1.displayDetails();
        } else {
            System.out.println("Products not Found...");
        }

      */


//        Product p3 = new Product(109,"Dove","Soap",80,30);
//        ApiResponse<Product> response = new ApiResponse<>(
//                true,"Product FOund Successfully",p3
//        );
//        System.out.println(response.getMessage());
//        System.out.println(response.getData().getName());


    }
}
