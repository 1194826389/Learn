package com.learn.basicthread.endmission.elegantlyendmission;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/11.
 */
public class BlockedThree implements Runnable {

    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // point1
                NeedsCleanup n1 = new NeedsCleanup(1);

                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    // point2
                    NeedsCleanup n2 = new NeedsCleanup(2);

                    try {
                        System.out.println("Calculating");

                        // 耗时非阻塞操作
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }

                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }
    }
}
