package domain.domain_service;

import com.company.domain.Price;

public class CompetitorPricier {

    private static final int DISCOUNTED_PRICE_PERCENTAGE = 10;

    public static Price discountedPrice(Price competitorProductPrice){
        return competitorProductPrice.reducePriceBy(DISCOUNTED_PRICE_PERCENTAGE);
    }
}


