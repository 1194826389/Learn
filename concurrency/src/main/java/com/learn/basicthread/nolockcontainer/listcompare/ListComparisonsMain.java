package com.learn.basicthread.nolockcontainer.listcompare;

/**
 * Created by hechao on 2017/5/16.
 * 测试结果：
 * synchronized ArrayList无论读取者和写入者的数量是多少，
 * 都具有大致相同的性能----读取者与其他读取者竞争锁的方式和写入者相同，
 * 但是，CopyonWriteArrayList在没有写入者时，速度会快许多，并且在油5个写入者的时候，速度仍旧明显地快。
 * 看起来我们应该尽量使用CopyWriteArrayList，对列表写入的影响并没有超过短期同步整个列表的影响，
 * 当然，你必须在你的具体应用中尝试着两种不同的方式，以了解到底哪个更好。
 *
 * CopyOnWriteArrayList简述
 * 在CopyOnWriteArrayList中，写入将导致创建整个底层数组的副本，而源数组将保留在原地，使得复制的数组在被修改时，读取操作可以安全的执行的，
 * 当修改完成时，一个原子的操作将把新的数组换入，使得新的读取操作可以看到这个新的修改。
 * CopyOnWriteArrayList好处之一是当多个迭代器同时遍历和修改这个列表时，不会抛出ConcurrentModificationException，
 * 因此不许编写特殊的代码去防范这种异常。适合多读少写的List。
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
