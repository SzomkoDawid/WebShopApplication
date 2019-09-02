package com.example.webshop.user.address;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String street;
    @Column(name = "post_code")
    private String postCode;

    @Override
    public String toString() {
        return
               country+","+city+","+street+","+postCode;
    }
}
