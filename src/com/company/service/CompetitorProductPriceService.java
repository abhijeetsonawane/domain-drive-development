package com.company.service;

import com.company.domain.Price;
import com.company.domain.Product;

import java.util.HashMap;

public class CompetitorProductPriceService {
    private HashMap<String, Price> productPriceMap = new HashMap<>();

    public CompetitorProductPriceService() {
        this.productPriceMap.put("IPad Prod", new Price(10.00));
        this.productPriceMap.put("GM Cricket bat", new Price(20.00));
        this.productPriceMap.put("Hero Ink Pen", new Price(30.00));
    }

    public Price priceFor(String productName){
        return this.productPriceMap.get(productName);
    }
}
