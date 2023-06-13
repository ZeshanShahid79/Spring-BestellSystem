package com.example.springbestellsystem;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepo {

    private final Map<String, Product> productList;

    public ProductRepo() {
        productList = new HashMap<>();

        productList.put("1", new Product("1", "Banana"));

        productList.put("2", new Product("2", "Pineapple"));
    }


    public List<Product> listProductList() {
        return new ArrayList<>(productList.values());
    }

    public Product get(String id) {
        return productList.get(id);
    }

}
