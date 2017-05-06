package com.learn.basicthread.innerthread;

/**
 * Created by hechao on 2017/5/6.
 * 线程内部类,如果在其他方法中需要访问内部类的时候，这样做就很有意义。
 */
public class InnerThreadOne {
    private int countDown = 5;
    private Inner inner;

    public InnerThreadOne(String name) {
        inner = new Inner(name);
    }
    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }
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
                System.out.println("InnerThreadOne sleep() interrupted");
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return getName() + ": " + countDown;
        }


    }


}
