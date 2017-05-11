package com.learn.basicthread.endmission.lockinterruptedendmission;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/11.
 */
public class InterruptingMain {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Blockedtwo());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}
