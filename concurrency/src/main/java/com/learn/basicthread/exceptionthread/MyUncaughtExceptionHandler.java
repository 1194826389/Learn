package com.learn.basicthread.exceptionthread;

/**
 * Created by hechao on 2017/4/27.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {

        System.out.println("caught " + e);

    }
}
