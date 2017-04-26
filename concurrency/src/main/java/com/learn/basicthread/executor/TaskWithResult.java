package com.learn.basicthread.executor;

import java.util.concurrent.Callable;

/**
 * Created by hechao on 2017/4/26.
 */
public class TaskWithResult implements Callable<String> {

    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return Thread.currentThread() + "     result of TastWithResult " + id;
    }
}
