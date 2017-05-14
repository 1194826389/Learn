package com.learn.basicthread.blockqueue.linkedorarrayblockqueue.sampleone;

import com.learn.basicthread.thread.LiftOff;

import java.util.concurrent.BlockingQueue;

/**
 * Created by hechao on 2017/5/13.
 */
public class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockeds;
    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockeds = queue;
    }

    public void add(LiftOff lo) {
        try {
            rockeds.put(lo);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("开始");
                LiftOff rocket = rockeds.take();
                rocket.run();
                System.out.println("结束");
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from takes");
        }
        System.out.println("Exiting LiftOffRunning");
    }
}
