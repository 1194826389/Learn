package com.learn.basicthread.threadcollaboration.waitnotify.producercomsumertwo;

/**
 * Created by hechao on 2017/5/13.
 */
public class Meal {
    private final int orderNum;
    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}
