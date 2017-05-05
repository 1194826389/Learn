package com.learn.basicthread.daemon.threadfactorydaemons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/4/27.
 * 后台线程是指在程序运行的时候在后台提供一种通用服务的线程，并且这种线程并不属于程序中不可或缺的部分，
 * 因此，当所有的后台线程结束时，程序也就终止了，同时也会杀死进程中的所有后台线程，
 * 反过来说，只要有任何非后台线程还在运行，程序就不会终止
 */
public class DaemonThreadFactoryMain {
    public static void main(String[] arg) throws InterruptedException {

        // 使用ThreadFactory 创建daemon线程，继承ThreadFactory，可以自定义一些Thread的功能，比如设置Thread的名字，优先级，是否后台线程。
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);


    }
}
