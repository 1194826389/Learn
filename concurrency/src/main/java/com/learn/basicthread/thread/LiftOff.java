package com.learn.basicthread.thread;

/**
 * Created by hechao on 2017/4/26.
 * 定义任务
 */
public class LiftOff implements Runnable {

    protected int countDown = 10; // default
    private static int taskCount = 1;
    private final int id = taskCount++;
    public LiftOff() {

    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return Thread.currentThread().getName() + " #" + id + " (" + (countDown > 0 ? countDown : "Liftoff!") + ")";
    }
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            // 在run()中对静态方法的Thread.yield()的调用时对线程调度器（Java线程机制的一部分，可以将CPU的一个线程转移为另一个线程）的一种建议，
            // 它在声明："我已经执行完声明周期中最重要的部分了，此刻正是切换给其他任务执行一段时间的大好时机。"
            // 这完全是选择性的，但是这里使用它是因为他会在这些实例中产生更加有趣的输出：你更有可能看到任务换进换出的证据。
            Thread.yield();
        }
    }
}
