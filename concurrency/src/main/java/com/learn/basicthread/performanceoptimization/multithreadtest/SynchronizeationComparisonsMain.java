package com.learn.basicthread.performanceoptimization.multithreadtest;

/**
 * Created by hechao on 2017/5/15.
 */
public class SynchronizeationComparisonsMain {
//    static BaseLine baseLine = new BaseLine();// 会产生同步问题
    static SynchronizedTest synchronizedTest = new SynchronizedTest();
    static LockTest lockTest = new LockTest();
//    static AtomicTest atomicTest = new AtomicTest();// 会产生同步问题
    static void test() {
        System.out.println("=============================");
        System.out.printf("%-12s : %13d\n","Cyscles",Accumulator.cycles);
//        baseLine.timedTest();
        synchronizedTest.timedTest();
        lockTest.timedTest();
//        atomicTest.timedTest();
//        Accumulator.report(synchronizedTest,baseLine);
//        Accumulator.report(lockTest,baseLine);
//        Accumulator.report(atomicTest,baseLine);
        Accumulator.report(synchronizedTest,lockTest);
//        Accumulator.report(synchronizedTest,atomicTest);
//        Accumulator.report(lockTest,atomicTest);
    }
    public static void main(String[] args) {
        int iterations = 10;
        System.out.println("Warmup");
//        baseLine.timedTest();

        for (int i = 0; i < iterations; i++) {
            test();
            Accumulator.cycles *= 2;
        }

        Accumulator.exec.shutdown();

    }
}
