package com.learn.basicthread.concurrency.synchronize;

/**
 * Created by hechao on 2017/5/8.
 */
public abstract class IntGenerator {
    // 因为canceled标志是boolean类型的，所以它是原子性的，即诸如赋值和返回值这样的简单操作在发生时没有中断的可能，
    // 因此你不会看到这个域处于在执行这些简单操作的过程中的中间状态，为了保证可见性，canceled标志还是volatile的。
    private volatile boolean canceled = false;
    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

}
