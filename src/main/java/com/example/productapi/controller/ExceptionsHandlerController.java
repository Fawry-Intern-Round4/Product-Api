package com.example.productapi.controller;

import com.example.productapi.error.GeneralError;
import com.example.productapi.error.IdsNotFoundError;
import com.example.productapi.exception.IdsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionsHandlerController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public GeneralError handelGeneralException(Exception e) {
        return new GeneralError(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public GeneralError handelNotFoundException(Exception e) {
        return new GeneralError(e.getMessage());
    }

    @ExceptionHandler(IdsNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public IdsNotFoundError handleNotFoundProducts(IdsNotFoundException e) {
        return new IdsNotFoundError(e.getMessage(), e.getIds());
    }
}
