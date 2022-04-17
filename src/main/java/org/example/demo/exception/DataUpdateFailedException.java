package org.example.demo.exception;

public class DataUpdateFailedException extends RuntimeException{

    public DataUpdateFailedException(String message) {
        super(message);
    }

    public DataUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
