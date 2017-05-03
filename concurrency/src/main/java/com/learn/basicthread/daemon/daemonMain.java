package com.learn.basicthread.daemon;

import com.learn.basicthread.priorities.SimplePriorities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/4/27.
 * 后台线程是指在程序运行的时候在后台提供一种通用服务的线程，并且这种线程并不属于程序中不可或缺的部分，
 * 因此，当所有的后台线程结束时，程序也就终止了，同时也会杀死进程中的所有后台线程，
 * 反过来说，只要有任何非后台线程还在运行，程序就不会终止
 */
public class daemonMain {
    public static void main(String[] arg) throws InterruptedException {
        // SimpleDaemons
//        for (int i = 0; i < 10; i++) {
//            Thread daemon = new Thread(new SimpleDaemons());
//            daemon.setDaemon(true);// must call before start()
//            daemon.start();
//        }
//        System.out.println("All daemons started");
//
//        TimeUnit.MILLISECONDS.sleep(175);

        // 使用ThreadFactory 创建daemon线程
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFractory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);


    }
}
