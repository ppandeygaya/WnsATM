package com.developerstack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class OutOfCashException extends Exception {

    public OutOfCashException (String message) {
        super(message);
    }
}