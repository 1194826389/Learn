package com.learn.basicthread.endmission.interruptendmission;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/11.
 */
public class InterruptingMain {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable runnable) throws InterruptedException {
        Future<?> f = exec.submit(runnable);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + runnable.getClass().getName());
//        exec.shutdownNow(); // Interrupts all threads
        f.cancel(true); // Interrupts an thread if running
        System.out.println("Interrupt sent to " + runnable.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
//        test(new SleepBlocked());
        test(new IOBlocked(System.in));
//        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
