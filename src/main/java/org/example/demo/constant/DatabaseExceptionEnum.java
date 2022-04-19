package org.example.demo.constant;

public enum DatabaseExceptionEnum {
    EXECUTION_FAILED("Execution of query failed."),
    PREPARATION_FAILED("PreparedStatement preparation failed."),
    UPDATE_FAILED("Data Update Failed.");
    private final String value;

    DatabaseExceptionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
