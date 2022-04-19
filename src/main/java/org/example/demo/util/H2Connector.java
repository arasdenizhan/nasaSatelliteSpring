package org.example.demo.util;

import org.example.demo.constant.DatabaseConnectionEnum;
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
                Class.forName(DatabaseConnectionEnum.DRIVER_CLASS_NAME.getValue());
                connection = DriverManager.getConnection(
                        DatabaseConnectionEnum.DATABASE_URL.getValue(),
                        DatabaseConnectionEnum.USERNAME.getValue(),
                        DatabaseConnectionEnum.PASSWORD.getValue());
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DatabaseConnectionFailedException("Database connection failed.", e);
        }
        return connection;
    }
}
