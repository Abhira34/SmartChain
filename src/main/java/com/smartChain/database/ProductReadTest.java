package com.smartChain.database;

import com.smartChain.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductReadTest {

    static void main(String[] args) {

        String sql = "select * from products";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()){
            System.out.println(" Product From Database ");
            System.out.println("-----------------------");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");

                Product product = new Product(id,name,category,price,quantity);
                System.out.println(
                        product.getId()+" | "+
                        product.getName()+" | "+
                        product.getCategory()+" | "+
                        product.getPrice()+" | "+
                        product.getQuantity()
                );
            }
            System.out.println("\n Product Read Successfully !!!");
        }
        catch (SQLException e){
            System.out.println("Failed to read products...");
            e.printStackTrace();
        }
    }
}
