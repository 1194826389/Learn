package com.learn.basicthread.threadcollaboration.lockcondition;



import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/12.
 */
public class WaxOn implements Runnable {

    private Car car;
    public WaxOn(Car c) {
        car = c;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}
