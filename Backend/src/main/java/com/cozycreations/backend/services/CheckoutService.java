package com.cozycreations.backend.services;

import com.cozycreations.backend.Repository.ProductRepository;
import com.cozycreations.backend.Repository.OrderRepository;
import com.cozycreations.backend.dto.CartItem;
import com.cozycreations.backend.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CheckoutService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public CheckoutService(OrderRepository orderRepository,
                           ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public CustomerOrder placeOrder(List<CartItem> cartItems) {

        CustomerOrder order = new CustomerOrder();
        order.setOrderTrackingNumber(UUID.randomUUID().toString());

        List<orderItem> items = new ArrayList<>();
        double total = 0;

        for (CartItem cartItem : cartItems) {

            Product product = productRepository.findById(cartItem.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            orderItem item = new orderItem();

            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(cartItem.getQuantity());

            double itemTotal = product.getPrice() * cartItem.getQuantity();
            item.setPrice(itemTotal);

            total += itemTotal;
            items.add(item);
        }

        order.setItems(items);
        order.setTotalPrice(total);

        return orderRepository.save(order);
    }
}
