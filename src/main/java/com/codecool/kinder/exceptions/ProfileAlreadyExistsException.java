package com.codecool.kinder.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProfileAlreadyExistsException extends Throwable {

    public ProfileAlreadyExistsException() {
    }

    public ProfileAlreadyExistsException(String message) {
        super(message);
    }

    public ProfileAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfileAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
