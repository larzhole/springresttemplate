package com.example.demo.swapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "People not found")
public class PeopleNotFoundException extends Exception {
    public PeopleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
