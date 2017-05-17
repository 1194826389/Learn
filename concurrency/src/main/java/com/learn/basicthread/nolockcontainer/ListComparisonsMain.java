package com.learn.basicthread.nolockcontainer;

/**
 * Created by hechao on 2017/5/16.
 */
public class ListComparisonsMain {
    public static void main(String[] args) {
        Tester.initMain();
        new SynchronizedArrayListTest(10,0);
        new SynchronizedArrayListTest(9,1);
        new SynchronizedArrayListTest(5,5);
        new CopyonWriteArrayListTest(10,0);
        new CopyonWriteArrayListTest(9,1);
        new CopyonWriteArrayListTest(5,5);
        Tester.exec.shutdown();
    }
}
