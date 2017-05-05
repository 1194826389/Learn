package com.learn.basicthread.daemon.DaemonsDontRunFinally;

import com.learn.basicthread.daemon.SimpleDaemon.SimpleDaemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/5.
 */
public class DaemonsDontRunFinallyMain {
    public static void main(String[] arg) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
//        t.setDaemon(true);
        t.start();





    }
}
