package com.learn.basicthread.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/14.
 * 死锁示例
 */
public class DeadlockingDiningPhilosophersMain {
    public static void main(String[] args) throws Exception {
        int ponder = 0;
        int size = 3;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }

        // 有死锁的情况
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(sticks[i],sticks[(i + 1) % size],i,ponder));
        }

//        // 消除循环等待条件，于是没有死锁问题
//        for (int i = 0; i < size; i++) {
//            if (i == (size - 1)) {
//                exec.execute(new Philosopher(sticks[0],sticks[i],i,ponder));
//            } else {
//                exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
//            }
//        }
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}
