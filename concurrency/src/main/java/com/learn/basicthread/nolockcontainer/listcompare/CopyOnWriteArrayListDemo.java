package com.learn.basicthread.nolockcontainer.listcompare;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hechao on 2017/5/16.
 */
public class CopyOnWriteArrayListDemo {
    /**
     * 读线程
     * @author hechao
     *
     */
    private static class ReadTask implements Runnable {
        List<String> list;

        public ReadTask(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (String str : list) {
                System.out.println(str);
            }
        }
    }

    /**
     * 写线程
     * @author hechao
     *
     */

    private static class WriteTask implements Runnable {
        List<String> list;
        int index;

        public WriteTask(List<String> list, int index) {
            this.list = list;
            this.index = index;
        }

        public void run() {
            list.remove(index);
            list.add(index, "write_" + index);
        }
    }


    public void run() {
        final int NUM = 10;
//        List<String> list = new ArrayList<String>(); // 会导致java.util.ConcurrentModificationException异常抛出，因为多线程读取线程的同步问题导致的
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < NUM; i++) {
            list.add("main_" + i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(NUM);
        for (int i = 0; i < NUM; i++) {
            executorService.execute(new ReadTask(list));
            executorService.execute(new WriteTask(list, i));
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new CopyOnWriteArrayListDemo().run();
    }


}
