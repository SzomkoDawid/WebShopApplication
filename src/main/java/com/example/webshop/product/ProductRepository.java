package com.example.webshop.product;
import com.example.webshop.category.CategoryType;
import org.springframework.data.repository.CrudRepository;

interface ProductRepository extends CrudRepository<Product, Long> {
    void deleteById(Long id);
}
