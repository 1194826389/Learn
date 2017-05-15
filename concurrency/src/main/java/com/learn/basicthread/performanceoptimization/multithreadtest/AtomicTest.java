package com.learn.basicthread.performanceoptimization.multithreadtest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hechao on 2017/5/15.
 */
public class AtomicTest extends Accumulator {

    {
        id = "Atomic";
    }

    private AtomicInteger atomicIndex = new AtomicInteger(0);
    private AtomicLong atomicvalue = new AtomicLong(0);

    @Override
    public void accumulate() {

        atomicvalue.getAndAdd(preLoaded[atomicIndex.getAndIncrement()]);

        if (atomicIndex.get() >= SIZE) {
            atomicIndex.set(0);
        }
    }

    @Override
    public long read() {
        return atomicvalue.get();
    }
}
