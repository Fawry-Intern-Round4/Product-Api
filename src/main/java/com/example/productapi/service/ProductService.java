package com.example.productapi.service;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);
    ProductResponse getProductById(Long id);
    ProductResponse getProductByCode(String code);
    List<ProductResponse> getAllProducts();
    ProductResponse updateProduct(Long id, ProductRequest productRequest);
    void deleteProduct(Long id);
}
