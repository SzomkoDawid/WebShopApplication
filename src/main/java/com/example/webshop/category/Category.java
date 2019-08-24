package com.example.webshop.category;
import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "types_of_category")
    private CategoryType categoryType;
    @Override
    public String toString() {
        return categoryType.toString();
    }
}
