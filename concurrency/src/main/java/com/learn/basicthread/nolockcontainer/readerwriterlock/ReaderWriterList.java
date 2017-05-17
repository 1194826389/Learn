package com.learn.basicthread.nolockcontainer.readerwriterlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hechao on 2017/5/17.
 * ReentrantReadWriteLock对象数据结构相对不频繁地写入，但是有多个任务要经常读取这个数据结构的这类情况进行优化。
 * ReentrantReadWriteLock是的你可以同事有多个读取者，只要他们都不试图写入即可。
 * 如果写锁已经被其他任务持有，那么任何读取者都不能访问直至这个锁被释放为止。
 *
 * ReentrantReadWriteLock是否能够提高程序的性能是完全不可确定的，它取决于诸如数据被读取的频繁的被修改的频率相比较的结果
 *
 */
public class ReaderWriterList<T> {
    private ArrayList<T> lockedList;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReaderWriterList(int size,T initialValue) {
        lockedList = new ArrayList<T>(Collections.nCopies(size,initialValue));
    }

    public T set(int index,T element) {
        Lock wlock = lock.writeLock();
        wlock.lock();
        try {
            return lockedList.set(index,element);
        } finally {
            wlock.unlock();
        }
    }

    public T get(int index) {
        Lock rlock = lock.readLock();
        rlock.lock();
        try {
            if (lock.getReadLockCount() > 1) {
                System.out.printf(String.valueOf(lock.getReadLockCount()));
            }
            return lockedList.get(index);
        } finally {
            rlock.unlock();
        }
    }

    static class ReaderWriterListTest {
        ExecutorService exec = Executors.newCachedThreadPool();
        private final static int SIZE = 100;
        private static Random rand = new Random(47);
        private ReaderWriterList<Integer> list = new ReaderWriterList<Integer>(SIZE,0);
        private class Writer implements Runnable {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        list.set(i,rand.nextInt());
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.printf("Writer finished,shutting down");
                exec.shutdownNow();
            }
        }

        private class Reader implements Runnable {

            @Override
            public void run() {
                try {
                    while (!Thread.interrupted()) {
                        for (int i = 0; i < SIZE; i++) {
                            list.get(i);
                            TimeUnit.MILLISECONDS.sleep(1);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public ReaderWriterListTest(int readers,int writers) {
            for (int i = 0; i < readers; i++) {
                exec.execute(new Reader());
            }

            for (int i = 0; i < writers; i++) {
                exec.execute(new Writer());
            }
        }

    }

    public static void main(String[] args) {
        new ReaderWriterListTest(30,1);
    }

}
