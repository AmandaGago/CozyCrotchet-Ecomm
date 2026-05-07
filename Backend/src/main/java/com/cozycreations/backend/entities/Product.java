package com.cozycreations.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //tells SpringBoot that this entity is a table
@Table(name = "products")//Sets the table name
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Product {
    //Mark a primary key
    @Id
    // tells spring to auto generate the id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Creates our Attributes
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;
    private int stockQuantity;
}
