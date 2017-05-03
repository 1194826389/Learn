package com.learn.basicthread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/4/27.
 */
public class DaemonFromFactory implements Runnable  {

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
