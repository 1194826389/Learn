package com.learn.basicthread.producercomsumer.waitnotify;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/12.
 */
public class Producor extends Thread {

    private final Queue<Integer> queue;
    private int maxSize;
    private Random random;

    public Producor(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
        random = new Random(7);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                int i = random.nextInt();
                TimeUnit.MILLISECONDS.sleep(i%10);
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                            System.out.println("Queue is full, Producer thread waiting for consumer to take something from queue");
                            queue.wait();

                    }



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
