package com.learn.basicthread.daemon.threadfactorydaemons;

import java.util.concurrent.ThreadFactory;

/**
 * Created by hechao on 2017/4/27.
 * 使用ThreadFactory 创建daemon线程
 */
public class DaemonThreadFactory implements ThreadFactory {
    private static int i = 0;
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.setName("DaemonThread-" + i++);
        return t;
    }
}
