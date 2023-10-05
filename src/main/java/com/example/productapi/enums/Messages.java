package com.example.productapi.enums;

import lombok.Getter;

@Getter
public enum Messages {
    PRODUCT_NOT_FOUND("Product not found"),
    PRODUCT_CODE_ALREADY_EXISTS("Product code already exists"),
    PRODUCT_CODE_NOT_FOUND("Product code not found"),
    ;
    final String message;

    Messages(String message) {
        this.message = message;
    }

}
