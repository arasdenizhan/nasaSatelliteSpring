package org.example.demo.util;

import org.example.demo.constant.DatabaseConstants;
import org.example.demo.exception.DatabaseConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connector {

    private static Connection connection = null;

    private H2Connector(){
        throw new UnsupportedOperationException("You can not create an object of connector class.");
    }

    public static synchronized Connection getConnection(){
        try{
            if(connection==null){
                Class.forName(DatabaseConstants.DRIVER_CLASS_NAME);
                connection = DriverManager.getConnection(
                        DatabaseConstants.DATABASE_URL,
                        DatabaseConstants.USERNAME,
                        DatabaseConstants.PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DatabaseConnectionFailedException("Database connection failed.", e);
        }
        return connection;
    }
}
