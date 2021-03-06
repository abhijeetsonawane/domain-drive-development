package com.company.domain;

import java.util.List;

public class Order {
    private int id;
    private List<Product> products;

    public Order(List<Product> products) {
        this.id = (int) Math.random();
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
