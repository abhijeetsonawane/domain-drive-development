package com.company;

import com.company.domain.*;
import com.company.service.CompetitorProductPriceService;
import domain.domain_service.CompetitorPricier;
import org.junit.jupiter.api.Test;

import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {

    @Test
    void shouldAddANewProduct() {
        Cart cart = new Cart();
        Price price = new Price(Currency.getInstance("INR"), 10.00);
        cart.addItem(new Item(new Product("IPad Prod", price)));
        cart.addItem(new Item(new Product("Hero Ink Pen", price)));
        cart.addItem(new Item(new Product("GM Cricket bat", price), 2));

        cart.removeItem(new Item(new Product("IPad Prod", price)));

        System.out.println(cart);

        assertEquals(cart.size(), 2);
    }

    @Test
    void shouldReturnTrueGivenWeCompareTheSameCart() {
        Cart cart = new Cart();
        Price price = new Price(Currency.getInstance("INR"), 10.00);
        cart.addItem(new Item(new Product("IPad Prod", price)));

        assertEquals(cart, cart);
    }

    @Test
    void shouldReturnFalseGivenTwoCarts() {
        Cart cart1 = new Cart();
        Price price = new Price(Currency.getInstance("INR"), 10.00);
        cart1.addItem(new Item(new Product("IPad Prod", price)));

        Cart cart2 = new Cart();
        cart1.addItem(new Item(new Product("IPad Prod", price)));

        assertNotEquals(cart1, cart2);
    }

    @Test
    void shouldReturnTenPercentDiscountedPriceGivenCompetitorPrice() {
        Price competitorPrice = new CompetitorProductPriceService().priceFor("IPad Pro");

        Price price = CompetitorPricier.discountedPrice(competitorPrice);

        assertEquals(price.amount(), 0.9);
    }

    @Test
    void shouldCreateAnOrderGivenTheShoppingCartIsCheckedOut() {
        Cart cart1 = new Cart();
        Price price = new Price(Currency.getInstance("INR"), 10.00);
        cart1.addItem(new Item(new Product("IPad Prod", price)));

        Order order = cart1.checkout();

        assertEquals(order.getProducts().size(), 1);
    }
}