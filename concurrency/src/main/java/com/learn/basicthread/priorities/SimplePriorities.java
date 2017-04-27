package com.learn.basicthread.priorities;

/**
 * Created by hechao on 2017/4/26.
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;
    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(this.priority);
        while (true) {
            // An expensive interruptable operation
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }
}
