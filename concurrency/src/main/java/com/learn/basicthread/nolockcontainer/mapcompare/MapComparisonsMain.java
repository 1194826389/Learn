package com.learn.basicthread.nolockcontainer.mapcompare;

/**
 * Created by hechao on 2017/5/17.
 * ConcurrentHashMap添加写入者的影响甚至不如CopyOnWriteArrayList明显，
 * 这是因为ConcurrentHashMap使用了一种不同的技术，它可以明显地最小化写入所造成的影响
 */
public class MapComparisonsMain {
    public static void main(String[] args) {
        Tester.initMain();
        new SynchronizedHashMapTest(10,0);
        new SynchronizedHashMapTest(9,1);
        new SynchronizedHashMapTest(5,5);
        new ConcurrentHashMapTest(10,0);
        new ConcurrentHashMapTest(9,1);
        new ConcurrentHashMapTest(5,5);
        Tester.exec.shutdown();
    }
}
