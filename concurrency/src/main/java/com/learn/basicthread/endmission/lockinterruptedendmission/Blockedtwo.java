package com.learn.basicthread.endmission.lockinterruptedendmission;

/**
 * Created by hechao on 2017/5/11.
 */
public class Blockedtwo implements Runnable {
    BlockedMutex blocked = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}
