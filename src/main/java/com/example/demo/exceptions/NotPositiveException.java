package com.example.demo.exceptions;

public class NotPositiveException extends Exception {
    public NotPositiveException() {
    }

    public NotPositiveException(String message) {
        super(message);
    }
}
