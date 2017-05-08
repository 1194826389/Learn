package com.learn.basicthread.concurrency.learnvolatile;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hechao on 2017/5/7.
 * 使用AtomicInteger，
 */
public class TestAtomicity {
    public volatile int inc =  0;
    private CyclicBarrier barrier;

    public void increase() {
        inc++;
    }

    public void start() {
        final TestAtomicity test = new TestAtomicity();
        barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(test.inc);
            }
        });
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 1000; j++)
                            test.increase();
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        exec.shutdown();

    }
}
