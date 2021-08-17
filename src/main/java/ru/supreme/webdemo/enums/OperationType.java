package ru.supreme.webdemo.enums;

public enum OperationType {

    CREATE("create"),
    UPDATE("update"),
    DELETE("delete");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }
}
