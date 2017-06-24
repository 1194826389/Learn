package com.learn.basicthread.producercomsumer.waitnotify;

import java.util.Queue;

/**
 * Created by hechao on 2017/5/12.
 */
public class Consumer extends Thread {

    private final Queue<Integer> queue;
    private int maxSize;
    public Consumer(Queue<Integer> queue,int maxSize,String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        System.out.println("Queue is empty, Consumer thread is waiting for producer thread to put something in queue");
                            queue.wait();

                    }
                    System.out.println("Consuming value: " + queue.remove());
                    queue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
