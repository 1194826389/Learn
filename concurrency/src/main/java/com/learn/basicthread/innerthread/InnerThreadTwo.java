package com.learn.basicthread.innerthread;

/**
 * Created by hechao on 2017/5/6.
 * 匿名内部类
 */
public class InnerThreadTwo {
    private int countDown = 5;
    private Thread t;
    public InnerThreadTwo(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("InnerThreadTwo sleep() interrupted");
                    e.printStackTrace();
                }
            }

            @Override
            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }
}
