package com.learn.basicthread.endmission.interruptendmission;


import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/11.
 */
public class SleepBlocked implements Runnable {
    @Override
    public void run() {


        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        System.out.println("Exiting SleepBlocked.run()");

    }
}
