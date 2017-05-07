package com.learn.basicthread.learnvolatile.model;

/**
 * Created by hechao on 2017/5/7.
 */
public class Data {
    private int id;
    private boolean stop;

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
