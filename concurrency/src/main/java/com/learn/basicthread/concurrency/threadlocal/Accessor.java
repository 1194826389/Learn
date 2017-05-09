package com.learn.basicthread.concurrency.threadlocal;

import java.util.Random;

/**
 * Created by hechao on 2017/5/9.
 */
public class Accessor implements Runnable {
    private final int id;
    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}
