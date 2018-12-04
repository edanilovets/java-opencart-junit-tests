package com.opencart.backend.model;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductRegistry {
    private static AtomicInteger COUNTER = new AtomicInteger(0);

    public static Product getProduct(){
        int index = COUNTER.incrementAndGet();
        return new Product()
                .withProductName("ProductName_" + index)
                .withProductModel("ProductModel_" + index)
                .withMetaTagTitle("ProductMetaTag_" + index);
    }
}
