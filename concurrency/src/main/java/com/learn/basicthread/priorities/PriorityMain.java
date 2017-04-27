package com.learn.basicthread.priorities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hechao on 2017/4/27.
 */
public class PriorityMain {
    public static void main(String[] arg){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));

        executorService.shutdown();
    }
}
