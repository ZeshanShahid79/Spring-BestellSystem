package com.example.springbestellsystem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id) {
        return shopService.getProduct(id);
    }

    @GetMapping("/products")
    public List<Product> products() {
        return shopService.listAllProducts();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable String id) {
        return shopService.getOrder(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProducts(@PathVariable String id) {
        this.shopService.deleteProduct(id);
    }

    @PostMapping
    public Order addOrder(@RequestBody List<String> productIds) {
        return shopService.addOrder(productIds);
    }

    @GetMapping("/orders")
    public List<Order> listAllOrders() {
        return shopService.listAllOrders();
    }

    @PutMapping("/update/order/{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        if (order.getId().equals(id)) {
            return shopService.updateOrder(order);
        }
        return null;
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable String id) {
        this.shopService.deleteOrder(id);
    }

}
