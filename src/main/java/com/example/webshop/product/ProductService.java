package com.example.webshop.product;

import java.util.List;

interface ProductService {
    List<Product> findAll();
    Product addProduct(Product product);
    void deleteById(Long id);

}
