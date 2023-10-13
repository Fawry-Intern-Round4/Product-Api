package com.example.productapi.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class IdsNotFoundException extends RuntimeException {
    private final List<Long> ids;

    public IdsNotFoundException(String message, List<Long> ids) {
        super(message);
        this.ids = ids;
    }

}
