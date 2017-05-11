package com.learn.basicthread.endmission.interruptendmission;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by hechao on 2017/5/11.
 */
public class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f(); // Lock acquired by this thread
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exting synchronizedBlocked.run()");
    }
}
