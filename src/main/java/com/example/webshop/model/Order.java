package com.example.webshop.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total_cost")
    private int totalCost;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Column(name = "date_of_order", columnDefinition = "DATE")
    private Date dateOfOrder;
    private Status status;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "order_lines_id", referencedColumnName = "id")
    private OrderLine orderLine;
}
