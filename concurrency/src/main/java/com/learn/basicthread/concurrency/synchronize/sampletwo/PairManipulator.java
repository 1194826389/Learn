package com.learn.basicthread.concurrency.synchronize.sampletwo;

/**
 * Created by hechao on 2017/5/9.
 */
public class PairManipulator implements Runnable {
    private PairManager pm;
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }


    @Override
    public void run() {

        while (true) {
            System.out.println(this);

            pm.increment();
        }

    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + " Pair: " + pm.getPair() + " checkCount = " + pm.checkCount.get();
    }
}
