package com.example.productapi.controller;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
    @GetMapping(params = "code")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponse getProductByCode(@RequestParam("code") String code) {
        return productService.getProductByCode(code);
    }
    @GetMapping(params = "ids")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductResponse> getAllProductsInIds(@RequestParam List<Long> ids) {
        return productService.getProductByListOfIds(ids);
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id, productRequest);
    }
}
