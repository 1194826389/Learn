package com.learn.basicthread.threadcollaboration.waitnotify.sampleone;

/**
 * Created by hechao on 2017/5/12.
 */
public class Car {
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException{
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException{
        while (waxOn) {
            wait();
        }
    }
}
