package com.example.productapi.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Validated
public class ProductRequest {
    @NotBlank(message = "Code is mandatory")
    @Size(min = 3, max = 10, message = "Code must be between 3 and 10 characters")
    private String code;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotNull
    @Digits(integer = 10, fraction = 2, message = "Price must be a number with 2 decimal places")
    @Positive(message = "Price must be positive")
    private Double price;
    @NotBlank(message = "Image is mandatory")
    private String image;
}
