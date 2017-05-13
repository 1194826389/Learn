package com.learn.basicthread.threadcollaboration.waitnotify.producercomsumer;

import java.util.Queue;
import java.util.Random;

/**
 * Created by hechao on 2017/5/12.
 */
public class Producor extends Thread {

    private Queue<Integer> queue;
    private int maxSize;

    public Producor(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, Producer thread waiting for consumer to take something from queue");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Producing value: " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}
