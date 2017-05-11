package com.learn.basicthread.endmission.volatileendmission;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/11.
 * 终结任务实例
 */
public class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entranceList = new ArrayList<Entrance>();
    private int number = 0;
    private final  int id;
    private static volatile boolean canceled = false;
    public static void  cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        entranceList.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            ++number;
            System.out.println(this + "Tatal: " + count.increament());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }

        System.out.println("Stopping " + this);
    }


    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue() + " ";
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance :
                entranceList) {
            sum += entrance.getValue();
        }
        return sum;
    }
}
