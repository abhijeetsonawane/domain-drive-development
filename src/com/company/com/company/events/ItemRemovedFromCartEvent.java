package com.company.events;

import com.company.domain.Product;

public class ItemRemovedFromCartEvent implements DomainEvent{
    private double cartId;
    private Product product;

    public ItemRemovedFromCartEvent(double cartId, Product product) {
        this.cartId = cartId;
        this.product = product;
    }
}
