package org.example.demo.constant;

public enum DatabaseQueryEnum {
    INSERT_QUERY("INSERT INTO SATELLITE (SATELLITE_ID, NAME, DATE, LINE1, LINE2) VALUES (?, ?, ?, ?, ?);"),
    GET_QUERY("SELECT * FROM SATELLITE ORDER BY ID DESC LIMIT ?;"),
    DELETE_QUERY("DELETE FROM SATELLITE WHERE NAME=?;");
    private final String value;

    DatabaseQueryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
