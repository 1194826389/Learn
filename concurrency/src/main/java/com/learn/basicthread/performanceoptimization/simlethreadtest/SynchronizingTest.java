package com.learn.basicthread.performanceoptimization.simlethreadtest;

/**
 * Created by hechao on 2017/5/15.
 */
public class SynchronizingTest extends Incrementable {
    @Override
    public synchronized void increment() {
        ++counter;
    }
}
