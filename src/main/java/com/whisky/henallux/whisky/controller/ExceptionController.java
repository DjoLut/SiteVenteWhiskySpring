package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.exception.AlreadyLoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AlreadyLoginException.class)
    public String AlreadyLogin(AlreadyLoginException ex)
    {
        return "redirect/index";
    }
}
