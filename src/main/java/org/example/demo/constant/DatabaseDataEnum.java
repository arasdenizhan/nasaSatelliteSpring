package org.example.demo.constant;

public enum DatabaseDataEnum {
    SATELLITE_ID("satelliteId"),
    NAME("name"),
    DATE("date"),
    LINE1("line1"),
    LINE2("line2");
    private final String value;

    DatabaseDataEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
