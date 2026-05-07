package com.cozycreations.backend.controllers;

import com.cozycreations.backend.dto.CheckoutRequest;
import com.cozycreations.backend.entities.CustomerOrder;
import com.cozycreations.backend.services.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderContoller {
    private final CheckoutService checkoutService;

    public OrderContoller(CheckoutService checkoutService){
        this.checkoutService =checkoutService;
    }

    @PostMapping("/checkout")
    public CustomerOrder checkout(@RequestBody CheckoutRequest request){
        return checkoutService.placeOrder((request.getItems()));
    }
}
