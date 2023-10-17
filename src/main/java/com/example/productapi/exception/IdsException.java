package com.example.productapi.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class IdsException extends RuntimeException {
    private final Set<Long> ids;

    public IdsException(String message, Set<Long> ids) {
        super(message);
        this.ids = ids;
    }

}
