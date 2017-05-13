package com.learn.basicthread.threadcollaboration.waitnotify.producercomsumerstandardsample;

/**
 * Created by hechao on 2017/5/13.
 */
public class WaitPerson implements Runnable {
    private RestaurantMain restaurantMain;

    public WaitPerson(RestaurantMain restaurantMain) {
        this.restaurantMain = restaurantMain;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurantMain.meal == null) {
                        wait(); // ... for the chef to produce a meal
                    }
                }
                System.out.println("Waitperson got " + restaurantMain.meal);
                synchronized (restaurantMain.chef) {
                    restaurantMain.meal = null;
                    restaurantMain.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }

    }
}
