package com.cozycreations.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String customerName;
    private String customerEmail;
    private String shippingAddress;
    private String orderTrackingNumber;
    private Double totalPrice;
    private double price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<orderItem> items;

}
