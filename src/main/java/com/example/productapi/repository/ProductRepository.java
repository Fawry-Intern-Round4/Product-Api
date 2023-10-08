package com.example.productapi.repository;

import com.example.productapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIdIn(Collection<Long> ids);
    Optional<Product> findProductByCode(String code);
    Boolean existsByCode(String code);
}
