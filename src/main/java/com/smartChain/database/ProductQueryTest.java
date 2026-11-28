package com.smartChain.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Why use PreparedStatement?
// It allows parameterized SQL statements, improves safety against SQL injection, and is generally preferable for repeated database operations.

public class ProductQueryTest {
    static void main(String[] args) {

        String sql = "SELECT * FROM products ";

        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1,103);
        ResultSet resultSet = statement.executeQuery())
        {
            System.out.println("--------------------------");
            System.out.println("  Products From DataBase  ");
            System.out.println("--------------------------");

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");

                System.out.println(id+" | "+name+" | "+category+" | "+price+" | "+quantity);
            }

        }catch (SQLException o){
            System.out.println("Query Failed...");
            o.printStackTrace();
        }
    }
}
