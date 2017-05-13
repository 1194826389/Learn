package com.learn.basicthread.threadcollaboration.waitnotify.producercomsumerstandardsample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hechao on 2017/5/13.
 */
public class RestaurantMain {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public RestaurantMain() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new RestaurantMain();
    }
}
