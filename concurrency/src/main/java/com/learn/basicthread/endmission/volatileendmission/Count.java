package com.learn.basicthread.endmission.volatileendmission;

import java.util.Random;

/**
 * Created by hechao on 2017/5/10.
 */
public class Count {
    private int count = 0;
    private Random rand = new Random(47);

    public synchronized int increament() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }

        return (count = ++temp);
    }

    public int value() {
        return count;
    }


}
