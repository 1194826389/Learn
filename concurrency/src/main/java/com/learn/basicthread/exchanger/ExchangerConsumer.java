package com.learn.basicthread.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by hechao on 2017/5/8.
 */
public class ExchangerConsumer<T> implements Runnable{


    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("消费者开始交换数据");
                holder = exchanger.exchange(holder);
                System.out.println("消费者交换数据结束，消费者交换得到数据：" + holder);
                for (T x : holder) {
                    // Fetch out value
                    value = x;
                    // ok for CopyOnWriteArrayList
                    holder.remove(x);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value：" + value);
    }
}
