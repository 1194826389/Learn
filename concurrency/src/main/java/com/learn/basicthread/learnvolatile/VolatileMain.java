package com.learn.basicthread.learnvolatile;

import com.learn.basicthread.learnvolatile.dao.DataDao;
import com.learn.basicthread.learnvolatile.model.Data;

/**
 * Created by hechao on 2017/5/7.
 */
public class VolatileMain {

    public static void main(String[] args) {

        // 测试可见性 ，测试的不太顺利
//        DataDao dataDao = new DataDao.DataDaoImpl();
//        Data data = new Data();
//        data.setId(1);
//        data.setStop(false);
//        dataDao.insertData(data);
//        TestVisibility testVisibility = new TestVisibility(data,dataDao);
//        testVisibility.start();

        // 测试原子性
        TestAtomicity testAtomicity = new TestAtomicity();
        testAtomicity.start();






    }
}
