package com.cozycreations.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CheckoutRequest {

    private String customerName;
    private String customerEmail;
    private String shippingAddress;

    private List<CartItem> items;
}
