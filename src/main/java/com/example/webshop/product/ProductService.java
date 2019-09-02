package com.example.webshop.product;
import com.example.webshop.category.CategoryType;

import java.util.List;

interface ProductService {
    List<Product> findAll();
    Product addProduct(Product product);
    void deleteById(Long id);
    Product findProductByCategory(CategoryType categoryType);
}
