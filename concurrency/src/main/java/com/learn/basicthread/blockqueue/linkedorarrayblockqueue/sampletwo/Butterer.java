package com.learn.basicthread.blockqueue.linkedorarrayblockqueue.sampletwo;

/**
 * Created by hechao on 2017/5/14.
 * Apply butter to toast
 */
public class Butterer implements Runnable {

    private ToastQueue dryQueue, butteredQueue;
    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                t.butter();
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted");
        }
    }
}
