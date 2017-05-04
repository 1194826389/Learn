package com.learn.basicthread.delayqueue.sampleone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/3.
 */
public class DelayedTask implements Runnable,Delayed{
    private static int counter = 0;
    private final int id = counter++;
    private final int delay; // 延迟时间
    private final long expire; // 到期时间

    protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();
    public DelayedTask(int delayInMilliseconds) {
        delay = delayInMilliseconds;
        // 5000毫秒 是多少纳秒呢？就是用TimeUnit.NANOSECONDS.convert方法进行转换的
        expire = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delay,TimeUnit.MILLISECONDS);
        sequence.add(this);
    }


    /**
     * 需要实现的接口，获得延迟时间   用过期时间-当前时间
     * 如果返回为负数，则到期
     * @param unit
     * @return
     */
    public long getDelay(TimeUnit unit) {
        return unit.convert(expire - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    /**
     * 负数 this < that
     * 0 this = that
     * 正数 this > that
     * 从小到大排序
     * @return
     */
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask)arg;
        if (expire < that.expire) {
            return -1;
        }
        if (expire > that.expire) {
            return 1;
        }
        return 0;
    }

    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]", delay) + " Task " + id;
    }

    public String summary() {
        return "(Task" + id + ":" + delay + ")";
    }

    public static class EndSentinel extends DelayedTask {
        private ExecutorService exec;
        public EndSentinel(int delay,ExecutorService e) {
            super(delay);
            exec = e;
        }

        public void run() {
            for (DelayedTask pt : sequence) {
                System.out.println(pt.summary() + " ");
            }
            System.out.println(this + "Calling shutdowmNow");
            exec.shutdownNow();
        }
    }
}
