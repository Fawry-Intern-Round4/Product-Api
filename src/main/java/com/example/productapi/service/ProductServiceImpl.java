package com.example.productapi.service;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.entity.Product;
import com.example.productapi.enums.Messages;
import com.example.productapi.mapper.ProductMapper;
import com.example.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        if (Boolean.TRUE.equals(productRepository.existsByCode(product.getCode()))) {
            throw new IllegalArgumentException(Messages.PRODUCT_CODE_ALREADY_EXISTS.getMessage());
        }
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(Messages.PRODUCT_NOT_FOUND.getMessage()));
        return productMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse getProductByCode(String code) {
        Product product = productRepository.findProductByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(Messages.PRODUCT_CODE_NOT_FOUND.getMessage()));
        return productMapper.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException(Messages.PRODUCT_NOT_FOUND.getMessage());
        }
        Product oldProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(Messages.PRODUCT_NOT_FOUND.getMessage()));
        if (!productRequest.getCode().equals(oldProduct.getCode())
                && (Boolean.TRUE.equals(productRepository.existsByCode(productRequest.getCode())))) {
            throw new IllegalArgumentException(Messages.PRODUCT_CODE_ALREADY_EXISTS.getMessage());
        }
        Product product = productMapper.toProduct(productRequest);
        product.setId(id);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException(Messages.PRODUCT_NOT_FOUND.getMessage());
        }
        productRepository.deleteById(id);
    }

}
