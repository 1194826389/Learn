package com.learn.basicthread.priorityblockingqueue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/4.
 */
public class PrioritizedTaskProducer implements Runnable{
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> q,ExecutorService e) {
        queue = q;
        exec = e; // 为EndSentinel所用
    }
    @Override
    public void run() {
        // 无边界队列；从不阻塞
        // 用随机的优先级填充它
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }

        try {
            // 每个250毫秒添加高优先级的task（缓缓地添加高优先级的task）
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            // 添加从1到10的优先级的task
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            queue.add(new PrioritizedTask.EndSentinel(exec));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Finished PrioritizedTaskProducer");

    }
}
