package com.learn.basicthread.deadlock;

/**
 * @author chao
 */
public class InfiniteLoopTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Thread1());
        thread.start();
    }
}
class Thread1 implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while(true){
            i++;
        }
    }
}
//public class jstackTestLock {
//    public static void main(String[] args) {
//        Thread t1 = new Thread(new DeadLockclass(0));//建立一个线程
//        Thread t2 = new Thread(new DeadLockclass(1));//建立另一个线程
//        Thread t3 = new Thread(new DeadLockclass(2));//建立另一个线程
//        t1.start();//启动一个线程
//        t2.start();//启动另一个线程
//        t3.start();//启动另一个线程
//    }
//}
//class DeadLockclass implements Runnable {
//    public int flag;// 控制线程
//    DeadLockclass(int flag) {
//        this.flag = flag;
//    }
//    public void run() {
//        /**
//         * 如果falg的值为true则调用t1线程
//         */
//        if (flag == 0) {
//            while (true) {
//                synchronized (Suo.o1) {
//                    System.out.println("o1 " + Thread.currentThread().getName());
//                    synchronized (Suo.o2) {
//                        System.out.println("o2 " + Thread.currentThread().getName());
//                        synchronized (Suo.o3) {
//                            System.out.println("o3 " + Thread.currentThread().getName());
//                        }
//                    }
//                }
//            }
//        }
//        /**
//         * 如果falg的值为false则调用t2线程
//         */
//        else if (flag == 1){
//            while (true) {
//                synchronized (Suo.o3) {
//                    System.out.println("o3 " + Thread.currentThread().getName());
//                    synchronized (Suo.o1) {
//                        System.out.println("o1 " + Thread.currentThread().getName());
//                        synchronized (Suo.o2) {
//                            System.out.println("o2 " + Thread.currentThread().getName());
//                        }
//                    }
//                }
//            }
//        } else {
//            while (true) {
//                synchronized (Suo.o2) {
//                    System.out.println("o2 " + Thread.currentThread().getName());
//                    synchronized (Suo.o3) {
//                        System.out.println("o3 " + Thread.currentThread().getName());
//                        synchronized (Suo.o1) {
//                            System.out.println("o1 " + Thread.currentThread().getName());
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//}
//
//class Suo {
//    static Object o1 = new Object();
//    static Object o2 = new Object();
//    static Object o3 = new Object();
//}
