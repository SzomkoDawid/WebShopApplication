package com.example.webshop.product;

import com.example.webshop.category.Category;
import com.example.webshop.category.CategoryType;
import com.example.webshop.product.author.Author;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    @Column(name = "stock_amount")
    private int stockamount;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private ProductType productType;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public void setCategory(String nameCatType){
        CategoryType ct = CategoryType.valueOf(nameCatType);
        Long id = Long.valueOf(ct.ordinal());
        this.category = new Category(id,ct);
    }
    @Override
    public String toString() {
        return
                name + description + price + stockamount + pictureUrl + productType + author + category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
