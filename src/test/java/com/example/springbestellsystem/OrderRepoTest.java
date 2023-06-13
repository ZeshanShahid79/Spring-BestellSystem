package com.example.springbestellsystem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderRepoTest {

    @Test
    void listAllOrdersAndExpectNotNull() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();

        //WHEN

        List<Order> actual = orderRepo.listAllOrders();

        //THEN
        assertNotNull(actual);
    }

    @Test
    void listAllOrders() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();

        //WHEN
        List<Order> actual = orderRepo.listAllOrders();

        //THEN
        List<Order> expected = List.of(
                new Order("1", List.of(new Product("1", "Banana")))
                , new Order("2", List.of(new Product("2", "Pineapple"))));

        assertEquals(expected, actual);

    }

    @Test
    void getOrderById() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();

        //WHEN
        Order actual = orderRepo.getOrder("1");

        //THEN
        Order expected = new Order("1", List.of(new Product("1", "Banana")));

        assertEquals(expected, actual);
    }

    @Test
    void addOrder() {
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();
        Order expected = new Order("3", List.of(
                new Product("1", "Apple")));

        //WHEN
        Order actual = orderRepo.addOrder(expected);

        //THEN
        assertEquals(expected, actual);

    }

}
