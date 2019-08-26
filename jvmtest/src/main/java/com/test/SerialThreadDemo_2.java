package com.test;

import sun.nio.ch.ThreadPool;

import java.util.HashMap;
import java.util.concurrent.Executors;

public class SerialThreadDemo_2 {
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                add();
            }
        });
        final Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //引用t1线程，等待t1线程执行完
                    t1.start();
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
            }
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //引用t2线程，等待t2线程执行完,一定要在此处t2.start()
                    //在主线程中调用t2.start()执行顺序不确定，因为若t2.join()先于t2.start()运行
                    //导致结果不确定
                    t2.start();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
            }
        });
        t3.start();
        Executors.newFixedThreadPool()
//        t2.start();
//        t1.start();
    }

    public static void add() {
        System.out.println("add start in thread name:" + Thread.currentThread().getName() + ",i:" + i);
        i++;
        System.out.println("add end in thread name:" + Thread.currentThread().getName() + " i,:" + i);
    }
}
