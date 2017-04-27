package com.learn.basicthread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/4/27.
 */
public class SimpleDaemons implements Runnable {
    public void run() {

        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + Thread.currentThread().isDaemon() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }

    }
}
