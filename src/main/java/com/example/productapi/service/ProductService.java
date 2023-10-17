package com.example.productapi.service;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;

import java.util.List;
import java.util.Set;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);
    ProductResponse getProductById(Long id);
    List<ProductResponse> getProductByListOfIds(Set<Long> ids);
    ProductResponse getProductByCode(String code);
    List<ProductResponse> getAllProducts();
    ProductResponse updateProduct(Long id, ProductRequest productRequest);
}
