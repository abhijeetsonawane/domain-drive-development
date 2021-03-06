package com.company.domain;

import com.company.events.DomainEvent;
import com.company.events.ItemAddedInCartEvent;
import com.company.events.ItemRemovedFromCartEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {
    private double id;
    private List<Item> items;
    private List<DomainEvent> domainEvents;

    public Cart() {
        this.id = Math.random();
        this.items = new ArrayList<>();
        this.domainEvents = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
        apply(new ItemAddedInCartEvent(this.id, item));
    }

    public int size(){
        return this.items.size();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    public void removeItem(Item itemToBeRemoved) {
        this.items.remove(itemToBeRemoved);
        apply(new ItemRemovedFromCartEvent(this.id, itemToBeRemoved.product()));
    }

    private void apply(DomainEvent domainEvent){
        this.domainEvents.add(domainEvent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Double.compare(cart.id, id) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
