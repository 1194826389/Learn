package com.learn.basicthread.performanceoptimization.multithreadtest;

/**
 * Created by hechao on 2017/5/15.
 */
public class BaseLine extends Accumulator {

    {
        id = "BaseLine";
    }
    @Override
    public void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) {
            index = 0;
        }
    }

    @Override
    public long read() {
        return value;
    }
}
