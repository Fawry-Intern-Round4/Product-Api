package com.example.productapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {
    private String code;
    private String name;
    private String description;
    private Double price;
    private String image;
}
