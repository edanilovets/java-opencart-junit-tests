package com.opencart.backend.model;

import java.util.concurrent.atomic.AtomicInteger;

public class UserRegistry {
    private static AtomicInteger COUNTER = new AtomicInteger(0);

    public static User getNewUser(){
        int index = COUNTER.incrementAndGet();
        return new User("User_" + index, "Pass_" + index);
    }
    public static User getAdmin(){
        return new User("admin", "admin");
    }
}
