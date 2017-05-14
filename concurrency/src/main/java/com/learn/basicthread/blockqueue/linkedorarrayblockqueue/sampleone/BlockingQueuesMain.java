package com.learn.basicthread.blockqueue.linkedorarrayblockqueue.sampleone;

import com.learn.basicthread.thread.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * Created by hechao on 2017/5/13.
 */
public class BlockingQueuesMain {
    static void getkey() {
        try {
            System.out.println("getkey start");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
            System.out.println("getkey over");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 60; i++) {
            runner.add(new LiftOff(2));
        }
        getkey("Press 'Enter' (" + msg + " test" + ")");
        t.interrupt();
        System.out.println("Finish " + msg + " test");
    }

    public static void main(String[] args)  {
//        test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
        // 还不知道SynchronousQueue是什么意思？
//        test("SynchronousQueue",  new SynchronousQueue<LiftOff>());
    }
}
