package com.learn.basicthread.CountDownLatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hechao on 2017/5/3.
 * CountDownLatch被用来同步一个或者多个任务，强制它们等待由其他任务执行的一组操作完成之后再执行。
 * 你可以向CountDownLatch对象设置一个初始计数值，
 * 任何在这个对象上调用await()的方法都将阻塞，直至这个计数值到达0.其他任务在结束其工作时，可以在该对象上调用countDown()来减小这个计数值。
 * CountDownLatch被设计为只触发一次，计数值不能被重置。如果你需要能够重置计数值得版本，则可以使用CyclicBarrier。
 *
 * 调用countDown()的任务在产生这个调用时并没有阻塞，只有对await()的调用会被阻塞，直至计数值为0，才可以运行.
 *
 * CountDownLatch的典型用法是将一个程序分为m+n个互为独立的任务，
 * 并创建计数器为m的CountDownLatch.当每个任务完成时，都会在这个锁存器上调用countDown()，使得计数器计数m减1。
 * 其他n个任务在这个锁存器上调用await(),将它们自己拦住，直至计数器计数m为0为止，才会开始运行。
 */
public class CountDownLatchDemo {
    private static final int SIZE = 100;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        // All must share a single CountDownLatch object
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        exec.shutdown();
    }
}
