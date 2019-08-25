package com.example.webshop.category;

import java.util.List;

public interface CategoryService {
    void deleteById(Long id);
    List<Category> findAll();
    Category findById(Long valueOf);
}