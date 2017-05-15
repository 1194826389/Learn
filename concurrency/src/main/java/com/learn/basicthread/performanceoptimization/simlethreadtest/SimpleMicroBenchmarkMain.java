package com.learn.basicthread.performanceoptimization.simlethreadtest;

/**
 * Created by hechao on 2017/5/15.
 * 单线程比较synchronized和lock,这里的测试结果显示synchronized比lock要快，我们再去看下更加复杂的多线程两者的比较
 */
public class SimpleMicroBenchmarkMain {
    static long test(Incrementable incr) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            incr.increment();
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        long synchTime = test(new SynchronizingTest());
        long lockTime = test(new LockingTest());

        System.out.printf("synchronized: %1$10d\n",synchTime);
        System.out.printf("Lock:         %1$10d\n",lockTime);
        System.out.printf("Lock/synchronized = %1$.3f",(double)lockTime/(double)synchTime);
    }
}
