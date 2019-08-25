package com.example.webshop.product;

import org.springframework.data.repository.CrudRepository;

interface ProductRepository extends CrudRepository<Product, Long> {
    void deleteById(Long id);

}
