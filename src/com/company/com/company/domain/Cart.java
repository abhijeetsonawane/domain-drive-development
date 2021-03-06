package com.company.domain;

import com.company.events.CartCheckedOutEvent;
import com.company.events.DomainEvent;
import com.company.events.ItemAddedInCartEvent;
import com.company.events.ItemRemovedFromCartEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cart {
    private double id;
    private List<Item> items;
    private Boolean isCheckedOut = false;
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

    public void removeItem(Item itemToBeRemoved) {
        this.items.remove(itemToBeRemoved);
        apply(new ItemRemovedFromCartEvent(this.id, itemToBeRemoved.product()));
    }

    public int size(){
        return this.items.size();
    }

    public Order checkout() {
        List<Product> products = items.stream()
                .map(Item::products)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Order order = new Order(products);
        this.isCheckedOut = true;
        apply(new CartCheckedOutEvent(this.id));

        return order;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
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
