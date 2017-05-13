package com.learn.basicthread.blockqueue.priorityblockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/4.
 */
public class PrioritizedTask implements Runnable,Comparable<PrioritizedTask>{
    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }


    @Override
    public int compareTo(PrioritizedTask that) {
        return priority < that.priority ? 1 : (priority > that.priority) ? -1 : 0;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);

    }

    @Override
    public String toString() {
        return String.format("[priority: %1$-3d]",priority) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + priority +")";
    }

    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService exec;
        public EndSentinel(ExecutorService e) {
            super(-1); // lowest priority in this program
            exec = e;
        }

        public void run() {
            int count = 0;
            for (PrioritizedTask pt : sequence) {
                System.out.println(pt.summary());
                if (++count % 5 == 0) {
                    System.out.println();
                }

            }
            System.out.println();
            System.out.println(this + "Calling shutdownNow");
        }

    }
}
