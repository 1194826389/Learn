package com.learn.basicthread.threadcollaboration.lockcondition;



import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/12.
 */
public class WaxOff implements Runnable {

    private Car car;
    public WaxOff(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax Off task");

    }
}
