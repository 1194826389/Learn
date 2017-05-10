package com.learn.basicthread.concurrency.synchronize.sampletwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/9.
 *
 * 测试synchronized方法比synchronized块效率要低
 */
public class CriticalalSectionMain {

    static void testApproached(PairManager pmanone,PairManager pmantwo) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //
        PairManipulator pmone = new PairManipulator(pmanone);
        PairManipulator pmtwo = new PairManipulator(pmantwo);

        PairChecker pcheckone = new PairChecker(pmanone);
        PairChecker pchecktwo = new PairChecker(pmantwo);

        exec.execute(pmone);
        exec.execute(pmtwo);

        exec.execute(pcheckone);
        exec.execute(pchecktwo);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }

        System.out.println("pm1: " + pmanone + "\npm2: " + pmantwo);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pmanone = new PairManagerOne();
        PairManager pmantwo = new PairManagerTwo();

        testApproached(pmanone,pmantwo);
    }
}
