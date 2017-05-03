package com.learn.basicthread.forkjoin;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by hechao on 2017/4/28.
 */
public class QuiklySortTaskTest {
    private static final int NARRAY = 16; //For demo only
    long[] array = new long[NARRAY];
    Random rand = new Random();


    @Before
    public void setUp() {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextLong()%100; //For demo only
        }
        System.out.println("Initial Array: " + Arrays.toString(array));
    }

    @Test
    public void testSort() throws Exception {
        ForkJoinTask sort = new QuickSortTask(array);
        ForkJoinPool fjpool = new ForkJoinPool();
        fjpool.submit(sort);
        fjpool.shutdown();

        fjpool.awaitTermination(30, TimeUnit.SECONDS);

        assertTrue(checkSorted(array));
    }

    boolean checkSorted(long[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > (a[i + 1])) {
                return false;
            }
        }
        return true;
    }
}