package com.learn.basicthread.innerthread;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/6.
 * 用一个有名字的Runnable实现
 */
public class InnerRunnableOne {
    private int countDown = 5;
    private Inner inner;
    public InnerRunnableOne(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable{
        Thread t;
        Inner(String name) {
            t = new Thread(this,name);
            t.start();
        }


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
                System.out.println("InnerRunnableOne sleep() interrupted");
                e.printStackTrace();
            }
        }
        @Override
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }



}
