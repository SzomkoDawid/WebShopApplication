package com.example.webshop.product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface ProductRepository extends CrudRepository<Product, Long> {
    void deleteById(Long id);
    Optional<Product> findById(Long id);
}
