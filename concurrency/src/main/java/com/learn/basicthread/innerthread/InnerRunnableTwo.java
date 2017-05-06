package com.learn.basicthread.innerthread;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/6.
 */
public class InnerRunnableTwo {
    private int countDown = 5;
    Thread t;

    public InnerRunnableTwo(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("InnerRunnableTwo sleep() interrupted");
                    e.printStackTrace();
                }
            }

            @Override
            public String toString() {
                return t.getName() + ": " + countDown;
            }

        },name);
        t.start();
    }



}
