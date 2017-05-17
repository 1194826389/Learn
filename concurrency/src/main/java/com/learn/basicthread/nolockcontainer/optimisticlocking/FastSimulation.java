package com.learn.basicthread.nolockcontainer.optimisticlocking;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hechao on 2017/5/17.
 */
public class FastSimulation {
    private static final int N_ELEMENTS = 100000;
    private static final int N_GENES = 30;
    private static final int N_EVOLVERS = 50;
    private static final AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENTS][N_GENES];
    private static Random rand = new Random(47);
    private static class Evolver implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                int element = rand.nextInt(N_ELEMENTS);
                for (int i = 0; i < N_GENES; i++) {
                    int previous = element - 1;
                    if (previous < 0) {
                        previous = N_ELEMENTS - 1;
                    }
                    int next = element + 1;
                    if (next >= N_ELEMENTS) {
                        next = 0;
                    }

                    int oldvalue = GRID[element][i].get();
                    int newvalue = oldvalue + GRID[previous][i].get() + GRID[next][i].get();
                    newvalue /=3;
                    if (!GRID[element][i].compareAndSet(oldvalue,newvalue)) {
                        System.out.println("Old value changed from " + oldvalue);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N_ELEMENTS; i++) {
            for (int j = 0; j < N_GENES; j++) {
                GRID[i][j] = new AtomicInteger(rand.nextInt(1000));
            }
        }

        for (int i = 0; i < N_EVOLVERS; i++) {
            exec.execute(new Evolver());
        }

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
