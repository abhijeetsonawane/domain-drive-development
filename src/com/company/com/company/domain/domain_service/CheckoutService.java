package com.company.domain.domain_service;

import com.company.domain.Cart;
import com.company.domain.Order;
import com.company.domain.Product;

import java.util.List;

public class CheckoutService {

    public Order checkout(Cart cart){
        List<Product> products = cart.checkout();

        return new Order(products);
    }
}
