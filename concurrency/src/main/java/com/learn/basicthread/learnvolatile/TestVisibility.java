package com.learn.basicthread.learnvolatile;

import com.learn.basicthread.learnvolatile.dao.DataDao;
import com.learn.basicthread.learnvolatile.model.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hechao on 2017/5/7.
 * 似乎比较难测试出volatile变量的可见性
 */
public class TestVisibility {
    DataDao dataDao;
    Data data;
    TestVisibility(Data data, DataDao dataDao) {
        this.dataDao = dataDao;
        this.data = data;
    }

    public void start() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (!dataDao.getData(1).isStop()) {
                    System.out.println("Thread while print");
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                dataDao.getData(1).setStop(true);
                System.out.println(dataDao.getData(1).isStop());
            }
        });

        executorService.shutdown();
    }
}
