package com.example.webshop.product;

import com.example.webshop.category.Category;
import com.example.webshop.category.CategoryRepository;
import com.example.webshop.category.CategoryType;
import com.example.webshop.product.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
                              AuthorRepository authorRepository) {
        this.productRepository = productRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }
    @Transactional
    public Product addProduct(Product product) {
        categoryRepository.save(product.getCategory());
        authorRepository.save(product.getAuthor());
        return productRepository.save(product);
    }

    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findProductByCategory(CategoryType categoryType) {
       return productRepository.findProductByCategory(categoryType);
    }

}
