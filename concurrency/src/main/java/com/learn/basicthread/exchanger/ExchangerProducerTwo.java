package com.learn.basicthread.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by hechao on 2017/5/8.
 */
public class ExchangerProducerTwo<T> implements Runnable{
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangerProducerTwo(Exchanger<List<T>> exchanger,Generator<T> gen,List<T> holder) {
        this.exchanger = exchanger;
        this.generator = gen;
        this.holder = holder;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemoMain.size; i++) {
                    holder.add(generator.next());

                }
                System.out.println("二号生产者生成了一个数据： " + holder);
                System.out.println("二号生成者开始交换数据");
                holder = exchanger.exchange(holder);
                System.out.println("二号生产者交换数据结束，得到数据：" + holder);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
