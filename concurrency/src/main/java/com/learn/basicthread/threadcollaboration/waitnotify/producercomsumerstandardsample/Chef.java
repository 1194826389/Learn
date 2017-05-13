package com.learn.basicthread.threadcollaboration.waitnotify.producercomsumerstandardsample;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/13.
 */
public class Chef implements Runnable {

    private RestaurantMain restaurantMain;
    private int count = 0;
    public Chef(RestaurantMain restaurantMain) {
        this.restaurantMain = restaurantMain;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurantMain.meal != null) {
                        wait(); // ... for the meal to be taken
                    }
                }
                if (++count == 10) {
                    System.out.println("Out of food,closing");
                    restaurantMain.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized (restaurantMain.waitPerson) {
                    restaurantMain.meal = new Meal(count);
                    restaurantMain.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
