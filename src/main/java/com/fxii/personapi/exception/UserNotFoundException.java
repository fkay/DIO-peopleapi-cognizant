package com.fxii.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String userName) {
        super(String.format("User %s not found", userName));
    }
}
