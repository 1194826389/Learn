package com.learn.basicthread.threadcollaboration.waitnotify.producercomsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/13.
 */
public class SimpleProducerConsumerMain {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("How to use wait and notify method in java");
        System.out.println("Solving Producer Consumer Problem");
        Queue<Integer> buffer = new LinkedList<Integer>();
        int maxSize = 10;
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Producor(buffer,maxSize,"Producer"));
        exec.execute(new Consumer(buffer,maxSize,"Consumer"));
        TimeUnit.MILLISECONDS.sleep(100);
        exec.shutdownNow();

    }
}
