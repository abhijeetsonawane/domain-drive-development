package com.company.events;

public class CartCheckedOutEvent implements DomainEvent {
    private double cartId;
    public CartCheckedOutEvent(double cartId) {
        this.cartId = cartId;
    }
}
