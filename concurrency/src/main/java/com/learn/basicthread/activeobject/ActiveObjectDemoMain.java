package com.learn.basicthread.activeobject;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by hechao on 2017/5/18.
 */
public class ActiveObjectDemoMain {
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    private Random rand = new Random(47);

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
        } catch (InterruptedException e) {
            System.out.printf("sleep() interrupted ");
        }
    }

    public Future<Integer> calculateInt(final int x, final int y) {
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.printf("starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public Future<Float> calculateFloat(final float x, final float y) {
        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.printf("starting " + x + " + " + y);
                pause(2000);
                return x + y;
            }
        });
    }

    public void shutdown() {
        exec.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemoMain d1 = new ActiveObjectDemoMain();
        List<Future<?>> results = new CopyOnWriteArrayList<Future<?>>();
        for (float f = 0.0F; f < 1.0F; f += 0.2F) {
            results.add(d1.calculateFloat(f,f));
        }

        for (int i = 0; i < 5; i++) {
            results.add(d1.calculateInt(i,i));
        }

        System.out.println("All asynch calls made");
        while (results.size() > 0) {
            for (Future<?> f : results) {
                if (f.isDone()) {
                    try {
                        System.out.println(" = " + f.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    results.remove(f);
                }
            }
        }
        d1.shutdown();
    }
}
