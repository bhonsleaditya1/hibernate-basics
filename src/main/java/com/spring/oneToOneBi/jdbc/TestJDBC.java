package com.spring.oneToOneBi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/hbdatabase";
        String user = "hbuser";
        String password = "hbuser";
        try {
            System.out.println("Connecting to database: " +jdbcURL);
            Connection postgres = DriverManager.getConnection(jdbcURL,user,password);
            System.out.println("Connection Successful!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
