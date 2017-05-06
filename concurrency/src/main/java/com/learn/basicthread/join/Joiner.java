package com.learn.basicthread.join;

/**
 * Created by hechao on 2017/5/6.
 */
public class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println(getName() + " join completed");
    }
}
