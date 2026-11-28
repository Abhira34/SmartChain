package com.smartChain.database;

import com.smartChain.model.Product;
import com.smartChain.storage.MySQLProductStorage;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class ProductUpdateTest {
    static void main(String[] args) {

        String sql = """
                update products set price = ? where id = ?
                """;

        int productId = 104;
        int newPrice = 70000;
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,newPrice);
            statement.setInt(2,productId);

            int rowUpdated = statement.executeUpdate();

            System.out.println(rowUpdated + " Products Updated Successfully");
        }
        catch (SQLException e){
            System.out.println("Failed to Update Product ...");
            e.printStackTrace();
        }


        // 2
        MySQLProductStorage storage = new MySQLProductStorage();

        Product product = new Product(
                101,
                "Surf Excel",
                "Detergent",
                150,
                75
        );

        storage.updateProduct(product);

        System.out.println("Update test completed.");
    }

}
