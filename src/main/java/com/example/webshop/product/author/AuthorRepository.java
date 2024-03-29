package com.example.webshop.product.author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    void deleteById(Long id);
}
