package com.company.events;

import com.company.domain.Item;
import com.company.domain.Product;

public class ItemAddedInCartEvent implements DomainEvent {
    private Double cartId;
    private Item item;

    public ItemAddedInCartEvent(Double cartId, Item item) {
        this.item = item;
        this.cartId = cartId;
    }

    public Item item() {
        return item;
    }

    public Product product(){
        return item.product();
    }
}
