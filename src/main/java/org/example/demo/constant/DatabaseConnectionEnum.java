package org.example.demo.constant;

public enum DatabaseConnectionEnum {
    DATABASE_URL("jdbc:h2:mem:testdb"),
    DRIVER_CLASS_NAME("org.h2.Driver"),
    USERNAME("sa"),
    PASSWORD("sa");
    private final String value;

    DatabaseConnectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
