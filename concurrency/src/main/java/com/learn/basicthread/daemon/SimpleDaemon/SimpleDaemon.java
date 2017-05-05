package com.learn.basicthread.daemon.SimpleDaemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/4/27.
 */
public class SimpleDaemon implements Runnable {
    public void run() {

        try {
//            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + Thread.currentThread().isDaemon() + " " + this);
//            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        } finally {
            // 后台进程在不执行finally子句的情况下就会终止其run方法
            // 意思就是当线程为后台线程的时候，finally子句将不会执行，但是如果你注释掉对setDaemon的调用，就会看到finally子句将会执行
            //
            System.out.println("This should alway run?");
        }

    }
}
