package com.learn.basicthread.daemon;

import java.util.concurrent.ThreadFactory;

/**
 * Created by hechao on 2017/4/27.
 * 使用ThreadFactory 创建daemon线程
 */
public class DaemonThreadFractory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
