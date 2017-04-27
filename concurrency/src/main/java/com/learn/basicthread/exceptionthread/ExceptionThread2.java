package com.learn.basicthread.exceptionthread;

/**
 * Created by hechao on 2017/4/27.
 */
public class ExceptionThread2 implements Runnable {
    public void run() {
        System.out.println("---------------ExceptionThread2---------------");
        Thread thread = Thread.currentThread();
        System.out.println("run() by " + thread);
        System.out.println("exception handler : " + thread.getUncaughtExceptionHandler());
        throw new RuntimeException("good");
    }
}
