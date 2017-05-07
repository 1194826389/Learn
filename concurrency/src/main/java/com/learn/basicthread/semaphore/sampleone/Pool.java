package com.learn.basicthread.semaphore.sampleone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by hechao on 2017/5/7.
 * 创建一个示例对象池
 */
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<T>();
    private volatile boolean[] checkedOut;
    private Semaphore available;
    public Pool(Class<T> classObject,int size) {
        this.size = size;
        checkedOut = new boolean[size]; // 默认都是false
        // 初始信号量为size
        available = new Semaphore(size,true);
        // 加载能被检查的对象
        for (int i = 0; i < size; i++) {
            try {
                items.add(classObject.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Semaphore availablePermits: " + available.availablePermits());
    }
    public T checkOut() throws InterruptedException {
        // 信号量减1
        available.acquire();
        return getItem();
    }

    public void checkIn(T x) {
        if (releaseItem(x)) {
            // 信号量加1
            available.release();
        }
    }

    private synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkedOut[i]){
                checkedOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }


    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        // 不在items中
        if (index == -1) {
            return false;
        }

        if (checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }

        return false;
    }

}
