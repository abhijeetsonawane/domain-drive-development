package com.company.domain;

import java.util.Currency;

public class Price {
    private Currency currency;
    private Double amount;

    public Price(Currency currency, Double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return currency.getSymbol() + this.amount;
    }
}
