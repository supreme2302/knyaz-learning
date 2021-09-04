package ru.supreme.webdemo.errorMessages;

public class RomkaCustomException extends Exception {

    public RomkaCustomException() {}

    public RomkaCustomException(String message) {
        super(message);
    }

    public static void main(String[] args) {

        RomkaCustomException.class.getAnnotations();

    }
}
