package org.example;

import org.example.Utils.PasswordHasher;
import org.example.models.User;

import javax.xml.crypto.Data;
import java.sql.*;

public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lightcity";

    // Database credentials
    static final String USER = "your_username";
    static final String PASS = "your_password";


    private Connection conn;

    public Database() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connecting to database...");
        } catch (Exception exp) {
            System.out.println("Database Exception : \n" + exp.toString());
            System.exit(0);
        }
    }
    //    Tables

    /**
     * Users
     */

    private void createTables() {
//        query example
        String query = "CREATE TABLE IF NOT EXISTS Users (username varchar(255) primary key ,password varchar(255));";

        try {
            Statement stmt = conn.createStatement();
           if(stmt.execute(query)){

           }else
               System.out.println("An error accord during operation");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loginGame(User user) {
        try {
            // Create a PreparedStatement object to execute the query with parameters
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE username=? AND password=?");
            // Set the parameters of the query
            stmt.setString(1, user.getUsername());
            stmt.setString(2, PasswordHasher.ToSha256(user.getPassword()));
            // Execute the query and get the results as a ResultSet
            ResultSet res = stmt.executeQuery();
            // Check if the ResultSet contains any rows
            if (res.next()) {
                // The username and password are correct, return true
                return true;
            } else {
                // The username and/or password are incorrect, return false
                return false;
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            throw new RuntimeException(e);
        }
    }

    public void registerGame(User user) {
        try {
            // Create a PreparedStatement object to execute the query with parameters
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)");
            // Set the parameters of the query
            stmt.setString(1, user.getUsername());
            stmt.setString(2, PasswordHasher.ToSha256(user.getPassword()));
            // Execute the query and get the number of rows affected
            int rowsAffected = stmt.executeUpdate();
            // Check if the query affected any rows
            if (rowsAffected == 1) {
                // The user was successfully registered, show a success message
                System.out.println("Registration successful.");
            } else {
                // The user was not registered, show an error message
                System.out.println("An error occurred during registration.");
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            throw new RuntimeException(e);
        }
    }
}
