package com.learn.basicthread.threadcollaboration.waitnotify.producercomsumer;

import java.util.Queue;

/**
 * Created by hechao on 2017/5/12.
 */
public class Consumer extends Thread {

    private Queue<Integer> queue;
    private int maxSize;
    public Consumer(Queue<Integer> queue,int maxSize,String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty, Consumer thread is waiting for producer thread to put something in queue");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consuming value: " + queue.remove());
                queue.notifyAll();
            }
        }
    }
}
