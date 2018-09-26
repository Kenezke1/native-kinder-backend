package com.codecool.kinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoImageFoundException extends Exception {

    public NoImageFoundException(String message) {
        super(message);
    }

    public NoImageFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoImageFoundException(Throwable cause) {
        super(cause);
    }

    public NoImageFoundException() {
    }
}
