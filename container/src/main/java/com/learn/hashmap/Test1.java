package com.learn.hashmap;

/**
 * Created by hechao on 2017/6/20.
 */
public class Test1 {
//    public synchronized void method() {
//        System.out.println("Hello World!");
//    }
//
//    public void metho1d() {
//        Lock lock = new ReentrantLock();
//        try {
//            lock.lock();
//            System.out.println("Hello World!");
//        } finally {
//            lock.unlock();
//        }
//
//    }
public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(new Test1().test());
}
    int test() {
        try {
            return func1();
        } finally {
            return func2();
        }
    }
    int func1() {
        System.out.println("func1");
        return 1;
    }
    int func2() {
        System.out.println("func2");
        return 2;
    }

}
