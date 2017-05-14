package com.learn.basicthread.blockqueue.linkedorarrayblockqueue.sampletwo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/14.
 */
public class Toaster implements Runnable {

    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue tq) {
        toastQueue = tq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                // Make toast
                Toast t = new Toast(count++);
                System.out.println(t);

                toastQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}
