package com.test;

import java.util.ArrayList;

/**
 * Created by hechao on 2017/7/25.
 */
public class TestVM {

    // TestVM memory
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024 * 40];
    }
    public static void fillHeap(int num) throws Exception {
        ArrayList<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    // TestVM thread
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("createBusyThread");
                while (true) {}
            }
        },"testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("createLockThread");
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }
    public static class createDeadThread implements Runnable {
        int a,b;
        createDeadThread(int a,int b) {
            this.a = a;
            this.b = b;
        }


        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void stackLeak() {
        stackLeak();
    }


    public static void main(String[] args) throws Exception {
        // TestVM memory
        Thread.sleep(10000);
        fillHeap(100);

        // TestVM Thread
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        createBusyThread();
//        br.readLine();
//        Object object = new Object();
//        createLockThread(object);
        // TestVM dead Thread
//        for (int i = 0; i < 100; i++) {
//            new Thread(new createDeadThread(1,2)).start();
//            new Thread(new createDeadThread(2,1)).start();
//        }

        // TestVM stackLeak
//        stackLeak();
    }
}
