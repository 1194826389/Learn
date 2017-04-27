package com.learn.basicthread.exceptionthread;

/**
 * Created by hechao on 2017/4/27.
 */
public class ExceptionThread implements Runnable {

    public void run() {
        throw new RuntimeException();
    }
}
