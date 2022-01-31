package com.fxii.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PesonNotFoundException extends Exception {
    public PesonNotFoundException(Long id) {
        super("Person not found with ID " + id);
    }
}
