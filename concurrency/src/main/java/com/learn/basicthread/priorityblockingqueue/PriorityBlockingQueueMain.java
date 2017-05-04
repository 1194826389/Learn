package com.learn.basicthread.priorityblockingqueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by hechao on 2017/5/4.
 */
public class PriorityBlockingQueueMain {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();

        System.out.println("生产task队列");
        exec.execute(new PrioritizedTaskProducer(queue,exec));
        System.out.println("消费task队列");
        exec.execute(new PrioritizedTaskConsumer(queue));

    }
}
