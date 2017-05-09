package com.learn.basicthread.concurrency.threadlocal;

import java.util.Random;

/**
 * Created by hechao on 2017/5/9.
 */
public class ThreadLocalVariableHolder {

//    // 不使用ThreadLocal变量的后果就是每个线程会共享该变量
//    private  Random rand = new Random(47);
//    private  int value = rand.nextInt(10000);
//
//    public  void increment() {
//        value++;
//    }
//
//    public  int get() {
//        return value;
//    }


    private static ThreadLocal<Integer> value = new ThreadLocal<Integer> () {
        private Random rand = new Random(47);
        @Override
        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }


}
