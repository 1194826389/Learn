package com.learn.basicthread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/4/27.
 */
class Daemon implements Runnable {
    private Thread[] t = new Thread[10];
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started. ");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

/**
 * Daemon线程被设置成后台模式，然后派生出许多子线程，这些子线程并没有被显示的设置为后台模式，
 * 不过它们的确是后台线程。接着Daemon线程进入无线循环，并在循环里调用yield()方法吧控制权交给其他进程。
 */
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
