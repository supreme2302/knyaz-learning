package ru.supreme.webdemo.errorMessages;

public class ErrorMessageDTO {

    private final String message;

    public ErrorMessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
