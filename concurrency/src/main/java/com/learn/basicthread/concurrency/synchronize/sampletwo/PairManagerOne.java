package com.learn.basicthread.concurrency.synchronize.sampletwo;

/**
 * Created by hechao on 2017/5/9.
 */
public class PairManagerOne  extends PairManager{
    @Override
    public synchronized void increment() {
        p.increamentX();
        p.increamentY();
        store(getPair());
    }
}
