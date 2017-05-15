package com.learn.basicthread.performanceoptimization.multithreadtest;

/**
 * Created by hechao on 2017/5/15.
 */
public class SynchronizedTest extends Accumulator {

    {
        id = "synchronized";
    }

    @Override
    public synchronized void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) {
            index = 0;
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}
