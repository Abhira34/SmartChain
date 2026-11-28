package com.smartChain.database;

import com.smartChain.storage.MySQLProductStorage;

import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDeleteTest {
    static void main(String[] args) {

        /*
        String sql = """
                delete from products where id = ?
                """;

        int productId = 106;
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,productId);
            int rowDeleted = statement.executeUpdate();

            System.out.println(rowDeleted+" Products Deleted Successfully");
        }
        catch (SQLException o){
            System.out.println("Failed to Delete Product...");
            o.printStackTrace();
        }
        */

        MySQLProductStorage storage = new MySQLProductStorage();
        int productId = 106;
        storage.deleteProduct(productId);
        System.out.println("Delete Test Completed...");
    }
}
