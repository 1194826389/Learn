package com.learn.basicthread.performanceoptimization.simlethreadtest;

/**
 * Created by hechao on 2017/5/15.
 */
public abstract class Incrementable {
    protected long counter = 0;
    public abstract void increment();
}
