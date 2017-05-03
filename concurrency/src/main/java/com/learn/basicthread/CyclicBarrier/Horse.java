package com.learn.basicthread.CyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/3.
 */
public class Horse implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;
    public Horse(CyclicBarrier b) {
        barrier = b;
    }

    public synchronized  int getStrides() {
        return strides;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    // produces 0,1 or 2
                    strides += rand.nextInt(3);
                    TimeUnit.MILLISECONDS.sleep(2000);
                    System.out.println("wait 2 second over.... and " + id + " strides = " + strides);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}
