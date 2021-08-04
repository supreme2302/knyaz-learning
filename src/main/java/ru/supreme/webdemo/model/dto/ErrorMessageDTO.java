package ru.supreme.webdemo.model.dto;

public class ErrorMessageDTO {

    private final String message;

    public ErrorMessageDTO(String message) {
        this.message = message;
    }

    public String getResponse() {
        return message;
    }
}
