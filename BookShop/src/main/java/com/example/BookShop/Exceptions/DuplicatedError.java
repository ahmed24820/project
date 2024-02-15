package com.example.BookShop.Exceptions;

public class DuplicatedError extends RuntimeException {
    public DuplicatedError(String message) {
        super(message);
    }

    public DuplicatedError() {
        super();
    }
}
