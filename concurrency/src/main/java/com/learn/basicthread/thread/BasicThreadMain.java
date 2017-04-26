package com.learn.basicthread.thread;

/**
 * Created by hechao on 2017/4/26.
 */
public class BasicThreadMain {
    public static void main(String[] arg){
//        // 调用任务
//        LiftOff launch = new LiftOff();
//        launch.run();
//        // 调用线程，线程调用任务
//        Thread t = new Thread(new LiftOff());
//        t.start();
//        System.out.println("Waiting for LiftOff");
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");


    }
}
