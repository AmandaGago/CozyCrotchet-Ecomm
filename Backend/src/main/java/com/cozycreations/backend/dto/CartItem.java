package com.cozycreations.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private Long productId;
    private int quantity;
}
