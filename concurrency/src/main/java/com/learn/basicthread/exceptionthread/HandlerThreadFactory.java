package com.learn.basicthread.exceptionthread;

import java.util.concurrent.ThreadFactory;

/**
 * Created by hechao on 2017/4/27.
 */
public class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println("---------------HandlerThreadFactory newThread---------------");
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("exception handler : " + t.getUncaughtExceptionHandler());
        return t;
    }
}
