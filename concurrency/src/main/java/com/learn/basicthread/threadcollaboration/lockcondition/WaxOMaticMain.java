package com.learn.basicthread.threadcollaboration.lockcondition;

import com.learn.basicthread.threadcollaboration.waitnotify.sampleone.Car;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/12.
 */
public class WaxOMaticMain {
    public static void main(String[] args) throws Exception {
        com.learn.basicthread.threadcollaboration.waitnotify.sampleone.Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5); // Run for a while
        exec.shutdownNow(); // Interrupt all task
    }
 }
