package com.whisky.henallux.whisky.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.TEMPORARY_REDIRECT)
public class AlreadyLoginException extends RuntimeException {

    public AlreadyLoginException()
    {
        super("Already logged in user tried to access signup/login page");
    }
}
