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
        try {
            while (!Thread.interrupted()) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {

                            System.out.println("Queue is full, Producer thread waiting for consumer to take something from queue");
                            queue.wait();

                    }

                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("Producing value: " + i);
                    queue.add(i);
                    queue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
