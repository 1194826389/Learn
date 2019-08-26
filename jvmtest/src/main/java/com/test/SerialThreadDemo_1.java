package com.test;


public class SerialThreadDemo_1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start");
        SerialThread serialThread_1 = new SerialThread("thread_1");
        SerialThread serialThread_2 = new SerialThread("thread_2");
        SerialThread serialThread_3 = new SerialThread("thread_3");
        serialThread_1.start();
        serialThread_1.join();
        serialThread_2.start();
        serialThread_2.join();
        serialThread_3.start();
        serialThread_3.join();
        System.out.println("main thread end");

    }

}
class SerialThread extends Thread {
    private String name;

    public SerialThread(String name) {
        this.name = name;
    }

    static int i = 0;

    @Override
    public void run() {
        System.out.println("SerialThread run start name:" + name + ",i=" + i);
        i++;
        System.out.println("SerialThread run end" + name + ",i=" + i);

    }
}
