package com.learn.basicthread.blockqueue.linkedorarrayblockqueue.sampletwo;

/**
 * Created by hechao on 2017/5/14.
 */
public class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;
    public Eater(ToastQueue finished) {
        this.finishedQueue = finished;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 阻塞直到下一片吐司做好
                Toast t = finishedQueue.take();
                // 验证吐司是正在排序上来和验证所有吐司正在涂果酱
                if (t.getId() != counter++
                        || t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>>>> Error: " + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }
}
