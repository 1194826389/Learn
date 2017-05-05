package com.learn.basicthread.daemon.DaemonsDontRunFinally;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/5.
 */
public class ADaemon implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This shoult always run?");
        }
    }
}
