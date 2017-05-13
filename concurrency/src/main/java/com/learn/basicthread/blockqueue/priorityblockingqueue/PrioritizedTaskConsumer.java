package com.learn.basicthread.blockqueue.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by hechao on 2017/5/4.
 */
public class PrioritizedTaskConsumer implements Runnable{
    private PriorityBlockingQueue<Runnable> queue;
    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // 使用当前线程去跑task
            while (!Thread.interrupted()) {
                queue.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished PrioritizedTaskConsumer");
    }
}
