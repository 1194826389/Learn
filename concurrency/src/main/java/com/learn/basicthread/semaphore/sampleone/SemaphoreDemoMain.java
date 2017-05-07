package com.learn.basicthread.semaphore.sampleone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/7.
 *
 *  来自java编程思想的话：正常的锁（synchronized或者lock）在任何时刻都只允许一个任务访问一项资源，
 *  而技术信号量允许n个任务同时访问这个资源，你还可以将信号量看做是在向外分发使用资源的许可证，景观实际上使用没有使用任何许可证对象
 *
 *
 *
 1.简介

 信号量(Semaphore)，有时被称为信号灯，是在多线程环境下使用的一种设施, 它负责协调各个线程, 以保证它们能够正确、合理的使用公共资源。

 一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。拿到信号量的线程可以进入代码，否则就等待。通过acquire()和release()获取和释放访问许可。

 2.概念
 Semaphore分为单值和多值两种，前者只能被一个线程获得，后者可以被若干个线程获得。

 更进一步，信号量的特性如下：信号量是一个非负整数（车位数），所有通过它的线程（车辆）都会将该整数减一（通过它当然是为了使用资源），当该整数值为零时，所有试图通过它的线程都将处于等待状态。在信号量上我们定义两种操作： Wait（等待） 和 Release（释放）。 当一个线程调用Wait（等待）操作时，它要么通过然后将信号量减一，要么一直等下去，直到信号量大于一或超时。Release（释放）实际上是在信号量上执行加操作，对应于车辆离开停车场，该操作之所以叫做“释放”是因为加操作实际上是释放了由信号量守护的资源。

 在java中，还可以设置该信号量是否采用公平模式，如果以公平方式执行，则线程将会按到达的顺序（FIFO）执行，如果是非公平，则可以后请求的有可能排在队列的头部。
 JDK中定义如下：
 Semaphore(int permits, boolean fair)
 　　   创建具有给定的许可数和给定的公平设置的Semaphore。

 Semaphore当前在多线程环境下被扩放使用，操作系统的信号量是个很重要的概念，在进程控制方面都有应用。Java并发库Semaphore 可以很轻松完成信号量控制，Semaphore可以控制某个资源可被同时访问的个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。比如在Windows下可以设置共享文件的最大客户端访问个数。

 3.应用
 Semaphore实现的功能就类似厕所有5个坑，假如有10个人要上厕所，那么同时只能有多少个人去上厕所呢？同时只能有5个人能够占用，当5个人中 的任何一个人让开后，其中等待的另外5个人中又有一个人可以占用了。另外等待的5个人中可以是随机获得优先机会，也可以是按照先来后到的顺序获得机会，这取决于构造Semaphore对象时传入的参数选项。单个信号量的Semaphore对象可以实现互斥锁的功能，并且可以是由一个线程获得了“锁”，再由另一个线程释放“锁”，这可应用于死锁恢复的一些场合。
 */
public class SemaphoreDemoMain {
    final static int SIZE = 25;
    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> pool = new Pool<Fat>(Fat.class,SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new CheckoutTask<Fat>(pool));
            System.out.println(i + " CheckoutTasks creadted");
        }
        System.out.println("All CheckoutTasks creadted");
        List<Fat> list = new ArrayList<Fat>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            System.out.println(i + ": main() thread checked out ");
            f.operation();
            list.add(f);
        }

        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    pool.checkOut();
                } catch (InterruptedException e) {
                    System.out.println("checkOut() Interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        System.out.println("Checking in objects in " + list);
        for (Fat f : list) {
            pool.checkIn(f);
        }

        // 第二次checkIn 会被忽略
        for (Fat f : list) {
            pool.checkIn(f);
        }
        exec.shutdown();
    }
}
