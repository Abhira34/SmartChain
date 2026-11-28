package com.smartChain.storage;

import com.smartChain.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smartChain.database.DatabaseConnection;
import com.smartChain.model.Product;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLProductStorage implements ProductStorage{


    // Save Products
  /*
    public void saveProducts(HashMap<Integer, Product> products) {

        String sql = """
                insert into products
                (id,name,category,price,quantity)
                values (?, ?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            for (Product product : products.values()) {
                statement.setInt(1,product.getId());
                statement.setString(2,product.getName());
                statement.setString(3,product.getCategory());
                statement.setInt(4,product.getQuantity());
                statement.setInt(5,product.getPrice());

                statement.executeUpdate();
            }

            System.out.println("Products Inserted Successfully!!!!");

        } catch (SQLException e){
            System.out.println("Failed To Insert Products....");
            e.printStackTrace();
        }
    }
*/

//----------------------------------------------------------------------------------------------------------------------


    // Add Product
    @Override
    public void addProduct(Product product) {
        String sql = """
                insert into products
                (id,name,category,price,quantity)
                values (?,?,?,?,?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

                statement.setInt(1,product.getId());
                statement.setString(2,product.getName());
                statement.setString(3,product.getCategory());
                statement.setInt(4,product.getPrice());
                statement.setInt(5,product.getQuantity());

                statement.executeUpdate();


            System.out.println("Products Inserted Successfully!!!!");

        } catch (SQLException e){
            System.out.println("Failed To Insert Products....");
            e.printStackTrace();
        }
    }


    // Read Product By ID
    @Override
    public Product getProductById(int id) {
        String sql = """
                select id, name, category, price, quantity from products where id = ?
                """;

        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,id);

            try(ResultSet resultSet = statement.executeQuery()){

                if(resultSet.next()){
                    return new Product(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("category"),
                            resultSet.getInt("price"),
                            resultSet.getInt("quantity")
                    );
                }
            }
        } catch (SQLException o){
            System.out.println("Failed to Get Product!!!");
            o.printStackTrace();
        }
        return null;
    }


    // Read All Product
    @Override
    public List<Product> getAllProduct() {

        String sql = """
                select id, name, category, price, quantity
                from products
                order by id
                """;

        List<Product> products = new ArrayList<>();

        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){

                Product product = new Product (
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getInt("price"),
                        resultSet.getInt("quantity")
                );
                products.add(product);
            }
        }
        catch (SQLException e){
            System.out.println("Failed to get products...");
            e.printStackTrace();
        }
        return products;
    }


    // Update Product
    @Override
    public void updateProduct(Product product) {

        String sql = """
                update products set name = ?,
                category = ?,
                price = ?,
                quantity = ?
                where id = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,product.getName());
            statement.setString(2, product.getCategory());
            statement.setInt(3,product.getPrice());
            statement.setInt(4,product.getQuantity());
            statement.setInt(5,product.getId());

            int rowUpdated = statement.executeUpdate();

            if(rowUpdated > 0){
                System.out.println("Products Updated Successfully");
            } else {
                System.out.println("Product Not Found...");
            }
        }
        catch (SQLException e){
            System.out.println("Failed to Update Product...");
            e.printStackTrace();
        }

    }


    // Delete Product
    @Override
    public void deleteProduct(int id) {

        String sql = """
                delete from products where id = ?
                """;
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,id);

            int rowDeleted = statement.executeUpdate();;

            if(rowDeleted > 0){
                System.out.println(rowDeleted+" Product Deleted Successfully");
            } else{
                System.out.println("Product Not Found...");
            }
        }
        catch (SQLException o){
            System.out.println("Failed to Delete Product...");
            o.printStackTrace();
        }

    }


}
