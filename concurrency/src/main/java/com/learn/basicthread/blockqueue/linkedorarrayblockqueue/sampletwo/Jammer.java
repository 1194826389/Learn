package com.learn.basicthread.blockqueue.linkedorarrayblockqueue.sampletwo;

/**
 * Created by hechao on 2017/5/14.
 */
public class Jammer implements Runnable {
    private ToastQueue butteredQueue,finishedQueue;

    public Jammer(ToastQueue buttered,ToastQueue finished) {
        this.butteredQueue = buttered;
        this.finishedQueue = finished;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 阻塞直到下一片t吐司出来
                Toast t = butteredQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
          }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }

        System.out.println("Jammer off");
    }
}
