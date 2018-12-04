package com.opencart.backend.model;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProductRegistry {
    //private static AtomicInteger COUNTER = new AtomicInteger(0);
    public static Product getProduct(){
        //int index = COUNTER.incrementAndGet();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return new Product()
                .withProductName("AAA_" + timeStamp)
                .withProductModel("AAA_" + timeStamp)
                .withMetaTagTitle("AAA_" + timeStamp);
    }
}
