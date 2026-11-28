package com.smartChain.database;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()){
            System.out.println("Database Connected Successfully...");
            System.out.println("Connection: "+connection);
        }
        catch (SQLException e){
            System.out.println("Database Connection failed...");
            e.printStackTrace();
        }
    }
}
