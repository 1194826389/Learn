package com.learn.basicthread.concurrency.synchronize.sampletwo;

import java.nio.channels.Pipe;

/**
 * Created by hechao on 2017/5/9.
 */
public class PairManagerTwo extends PairManager {

    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.increamentX();
            p.increamentY();
            temp = getPair();
        }

        store(temp);
    }
}
