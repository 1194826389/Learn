package com.learn.basicthread.concurrency.synchronize.sampleone;

/**
 * Created by hechao on 2017/5/8.
 */
public class EvenCheckMain {
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
