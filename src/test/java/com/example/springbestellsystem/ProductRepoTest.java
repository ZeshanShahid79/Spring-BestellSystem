package com.example.springbestellsystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class ProductRepoTest {

    @Test
    void testListProduct() {
        //GIVEN
        ProductRepo productRepo = new ProductRepo();

        //WHEN
        List<Product> actual = productRepo.listProductList();

        //THEN
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("1", "Banana"));
        expected.add(new Product("2", "Pineapple"));

        assertEquals(expected, actual);
    }

    @Test
    void getProduct() {
        //GIVEN
        ProductRepo productRepo = new ProductRepo();

        //WHEN
        Product actual = productRepo.get("1");

        //THEN
        Product expected = new Product("1", "Banana");

        assertEquals(expected, actual);

    }

    @Test
    void returnNullWhenNoExistingId() {
        //GIVEN
        ProductRepo productRepo = new ProductRepo();

        //WHEN
        Product actual = productRepo.get("4");

        //THEN

        assertNull(actual);
    }
}
