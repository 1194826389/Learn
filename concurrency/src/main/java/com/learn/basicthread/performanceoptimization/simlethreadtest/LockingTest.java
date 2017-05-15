package com.learn.basicthread.performanceoptimization.simlethreadtest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hechao on 2017/5/15.
 */
public class LockingTest extends Incrementable {

    private Lock lock = new ReentrantLock();
    @Override
    public void increment() {
        lock.lock();
        try {
            ++counter;
        } finally {
            lock.unlock();
        }
    }
}
