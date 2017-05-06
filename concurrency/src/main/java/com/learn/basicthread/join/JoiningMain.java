package com.learn.basicthread.join;

/**
 * Created by hechao on 2017/5/6
 * 一个线程(Joiner)可以在调用其他线程(Sleeper)的join方法，其效果是这个线程(Joiner)在其他线程(Sleeper)调用Sleeper.join()之后，
 * 此线程(Joiner)将被挂起，等待一段时间直到其他线程(Sleeper)结束才继续执行
 * 也可以在调用join时带上一个超时参数，这样子如果目标线程在这段时间到期时还没有计数的话，join()方法总能返回。
 * 对join方法的调用可以被中断，做大是在调用线程上调用interrupt方法，这是需要用到try-catch子句
 */
public class JoiningMain {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy",10500);
        Sleeper grumpy = new Sleeper("Grumpy",10500);
        Joiner dopey = new Joiner("dopey",sleepy);
        Joiner doc = new Joiner("doc",sleepy);
        grumpy.interrupt();

    }
}
