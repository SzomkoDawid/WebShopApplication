package com.example.webshop.model;
import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "types_of_category")
    private String typesOfCategory;
}
