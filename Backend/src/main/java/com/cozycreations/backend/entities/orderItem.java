package com.cozycreations.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class orderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "CusotmerOrder_id")
    private CustomerOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

