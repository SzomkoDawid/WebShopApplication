package com.example.webshop.product;
import com.example.webshop.category.CategoryType;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product addProduct(Product product);
    void deleteById(Long id);
    Optional<Product> findById(Long id);
}
