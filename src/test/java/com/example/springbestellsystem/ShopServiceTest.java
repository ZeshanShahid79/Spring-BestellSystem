package com.example.springbestellsystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class ShopServiceTest {

    private final OrderRepo orderRepo = mock(OrderRepo.class);
    private final ProductRepo productRepo = mock(ProductRepo.class);
    private final ShopService shopService = new ShopService(productRepo, orderRepo);

    @Test
    void getProduct() {
        //GIVEN
        Product expected = new Product("1", "Banana");

        // WHEN
        when(productRepo.get("1")).thenReturn(expected);
        Product actual = shopService.getProduct("1");

        // THEN
        // verifiy nutzen wir um die logik der methode zu prüfen
        verify(productRepo).get("1");
        assertEquals(expected, actual);
    }

    @Test
    void listAllProducts() {
        //GIVEN
        List<Product> expected = new ArrayList<>(List.of(new Product("1", "Banana"), new Product("2", "Pineapple")));

        // WHEN
        when(productRepo.listProductList()).thenReturn(expected);
        List<Product> actual = shopService.listAllProducts();

        // THEN
        verify(productRepo).listProductList();
        assertEquals(expected, actual);

    }

    @Test
    void getOrder() {
        // GIVEN
        Order expected = new Order("1", List.of(new Product("1", "Banana")));

        // WHEN
        when(orderRepo.getOrder("1")).thenReturn(expected);
        Order actual = shopService.getOrder("1");

        // THEN
        verify(orderRepo).getOrder("1");
        assertEquals(expected, actual);
    }

    @Test
    void listAllOrders() {
        // GIVEN
        List<Order> expected = new ArrayList<>(List.of(new Order("1", List.of(new Product("1", "Banana"))), new Order("2", List.of(new Product("2", "Pineapple")))));

        // WHEN
        when(orderRepo.listAllOrders()).thenReturn(expected);
        List<Order> actual = shopService.listAllOrders();

        // THEN
        verify(orderRepo).listAllOrders();
        assertEquals(expected, actual);
    }
}
