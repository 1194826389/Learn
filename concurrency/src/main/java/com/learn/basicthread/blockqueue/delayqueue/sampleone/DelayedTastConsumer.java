package com.learn.basicthread.blockqueue.delayqueue.sampleone;

import java.util.concurrent.DelayQueue;

/**
 * Created by hechao on 2017/5/3.
 */
public class DelayedTastConsumer implements Runnable {

    private DelayQueue<DelayedTask> q;

    public DelayedTastConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.currentThread().isInterrupted();

                q.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished DelayedTaskConsumer");
    }
}
