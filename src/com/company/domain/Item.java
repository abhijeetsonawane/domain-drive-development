package com.company.domain;

import java.util.Objects;

public class Item {
    private Product product;
    private Integer quantity;

    public Item(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return product.equals(item.product) &&
                quantity.equals(item.quantity);
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public Product product() {
        return product;
    }
}
