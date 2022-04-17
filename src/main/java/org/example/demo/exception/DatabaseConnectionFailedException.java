package org.example.demo.exception;

public class DatabaseConnectionFailedException extends RuntimeException{
    public DatabaseConnectionFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
