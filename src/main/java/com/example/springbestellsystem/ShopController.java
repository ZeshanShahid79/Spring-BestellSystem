package com.example.springbestellsystem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping("{id}")
    public Product getProductById(@PathVariable String id) {
        return shopService.getProduct(id);
    }

    @GetMapping
    public List<Product> products() {
        return shopService.listAllProducts();
    }

    @GetMapping("{id}")
    public Order getOrderById(@PathVariable String id) {
        return shopService.getOrder(id);
    }

    @PostMapping
    public Order addOrder(List<String> productIds) {
        return shopService.addOrder(productIds);
    }

    @GetMapping
    public List<Order> listAllOrders() {
        return shopService.listAllOrders();
    }
}
