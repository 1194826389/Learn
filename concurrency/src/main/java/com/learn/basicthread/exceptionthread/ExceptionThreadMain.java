package com.learn.basicthread.exceptionthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hechao on 2017/4/27.
 */
public class ExceptionThreadMain {
    public static void main(String[] arg) {
        // 线程默认异常处理器只有在不存在线程专业的未捕获异常处理器的情况才会被调用。
        // 系统会先检查线程专有版本，如果没有发现，则检查线程组是否有其专业的uncaughtException()的方法，
        // 如果也没有，再调用DefaultUncaughtExceptionHandler
//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());

        try {

//            executorService.execute(new ExceptionThread());
            executorService.execute(new ExceptionThread2());
        } catch (RuntimeException e) {
            System.out.println("Exception has been handled");
        } finally {
            executorService.shutdown();
        }


    }
}
