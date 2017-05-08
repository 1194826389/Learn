package com.learn.basicthread.concurrency.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hechao on 2017/5/8.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        // 一个任务有可能在另外一个任务执行第一个对currentEvenValue的递增操作之后，但是在执行第二个操作之前，调用了next方法。这就会🙆这个值处于不恰当的状态。

//        // 第一种方式加锁
//        synchronized (this) {
//            ++currentEvenValue; // 这里是危险点
//            Thread.yield();
//            ++currentEvenValue;
//            return currentEvenValue;
//        }
        // 第二种方式加锁
        // try-finally 所需的代码比synchronized关键字要好，这也代表了显示的Lock对象的优点之一。
        // 如果在使用synchronized关键字是，某些事物失败了那么就会抛出一个异常，
        // 但是你没有机会去做任何清理的工作，以维护系统使其处于良好的状态。
        // 有了显示的Lock对象，就可以就使用子句将系统维护在正确的状态

        // 大体上，当你使用关键字时，需要写的代码量更少，并且用户错误出现的可能性也会降低，因此通常只有在解决特殊问题是才使用显示的Lock对象，
        lock.lock();
        try {
            ++currentEvenValue; // 这里是危险点
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }



    }


}
