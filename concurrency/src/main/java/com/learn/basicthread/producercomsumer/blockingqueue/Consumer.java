package com.learn.basicthread.producercomsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by hechao on 2017/6/11.
 */
public class Consumer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + sharedQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
