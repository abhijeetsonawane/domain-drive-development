package com.company.domain;

import java.util.Currency;

public class Price {
    private Currency currency;
    private Double amount;

    public Price(Currency currency, Double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Price(Double amount) {
        this.currency = Currency.getInstance("INR");
        this.amount = amount;
    }

    public Double amount() {
        return amount;
    }

    public Price applyDiscount(Price competitorsPrice, Integer discountPercentage){
        Double discountedPrice = (competitorsPrice.amount/this.amount)*(discountPercentage/100);
        return new Price(this.currency, discountedPrice);
    }

    @Override
    public String toString() {
        return currency.getSymbol() + this.amount;
    }

    public Price reducePriceBy(int discountedPricePercentage) {
        return new Price(this.currency, this.amount/discountedPricePercentage);
    }
}
