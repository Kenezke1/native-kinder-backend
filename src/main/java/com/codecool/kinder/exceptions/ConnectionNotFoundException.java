package com.codecool.kinder.exceptions;

public class ConnectionNotFoundException extends Throwable {
    public ConnectionNotFoundException() {
    }

    public ConnectionNotFoundException(String message) {
        super(message);
    }

    public ConnectionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionNotFoundException(Throwable cause) {
        super(cause);
    }
}
