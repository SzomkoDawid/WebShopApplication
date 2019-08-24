package com.example.webshop.cart;

import com.example.webshop.order.OrderLine;
import lombok.*;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "cart")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private List<OrderLine> orderLines = new ArrayList<>();
}
