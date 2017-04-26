package com.learn.basicthread.executor;

import com.learn.basicthread.thread.LiftOff;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by hechao on 2017/4/26.
 * 执行器（Executor）将为你管理Thread对象，蓉儿简化了并发编程。Executor在客户端和任务执行虹之间提供了一个间接层；
 * 与客户端直接执行任务不同，这个中介对象将执行任务。Executor允许你管理异步任务的执行，而无需显示的管理现场的生命周期
 */
public class ExecutorMain {
    public static void main(String[] arg){
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new LiftOff());
//        }
//        executorService.shutdown();


        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {

            try {
//                TimeUnit.MILLISECONDS.sleep(2000);
                // get() blocks untils completion;
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }  finally {
                exec.shutdown();
            }
        }



    }
}
