package com.learn.singleton.lazyload;

/**
 * Created by hechao on 2017/3/28.
 */
public class ASingleton {
    private static ASingleton instance;
    private static final Object syncRoot = new Object();
    private ASingleton() {}

    public static ASingleton getInstance() {
        // 不用线程每次都加锁
        if (instance == null) {
            // 在同一时刻加了锁的那部分程序只有一个线程可以进入
            synchronized (syncRoot) {
                // 由于synchrinized机制，多个线程只有一个进入，其他在外排队等候，必须要其中一个进入并且出来后，另一个才能进入。
                // 而此时如果没有第二重的instance是否为null的判断，则第一个线程创建了实例，
                // 而第二个线程还是可以继续再创建新的实例，这就没有达到单例的目的
                if (instance == null) {
                    instance = new ASingleton();
                }
            }
        }
        return instance;
    }
}
