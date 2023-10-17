package com.example.productapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "Code is mandatory")
    @Size(min = 3, max = 10, message = "Code must be between 3 and 10 characters")
    String code;
    @NotBlank(message = "Name is mandatory")
    String name;
    @NotBlank(message = "Description is mandatory")
    String description;
    @NotNull(message = "Price is mandatory")
    @Digits(integer = 10, fraction = 2, message = "Price must be a number with 2 decimal places")
    @Positive(message = "Price must be greater than 0")
    Double price;
    @NotBlank(message = "Image is mandatory")
    String image;
}
