package com.learn.basicthread.simplethread;

/**
 * Created by hechao on 2017/5/5.
 */
public class SimpleThreadMain {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
