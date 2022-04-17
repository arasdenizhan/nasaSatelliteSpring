package org.example.demo.constant;

public class DatabaseConstants {
    private DatabaseConstants(){
        throw new UnsupportedOperationException("You can not create an object of DatabaseConstants class");
    }

    // ### DATABASE CONNECTION CONSTANTS ###
    public static final String DATABASE_URL = "jdbc:h2:mem:testdb";
    public static final String DRIVER_CLASS_NAME = "org.h2.Driver";
    public static final String USERNAME ="sa";
    public static final String PASSWORD = "sa";

    // ### DATABASE DATA CONSTANTS ###
    public static final String SATELLITE_ID = "satelliteId";
    public static final String NAME = "name";
    public static final String DATE = "date";
    public static final String LINE1 = "line1";
    public static final String LINE2 = "line2";

    // ### DATA MANIPULATION QUERIES ###

    // ID IS AUTO_INCREMENTED WE DO NOT HAVE TO SPECIFY IT INSIDE OF OUR QUERY.
    // INSERT INTO SATELLITE VALUES (id, 'satelliteId', 'name', 'date', 'line1', 'line2');
    public static final String INSERT_QUERY = "INSERT INTO SATELLITE (SATELLITE_ID, NAME, DATE, LINE1, LINE2) VALUES (?, ?, ?, ?, ?);";
}
