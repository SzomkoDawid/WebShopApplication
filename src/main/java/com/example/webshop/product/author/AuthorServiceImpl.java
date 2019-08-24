package com.example.webshop.product.author;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
