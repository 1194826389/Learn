package com.learn.basicthread.concurrency.lock;

import com.learn.basicthread.innerthread.ThreadMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/8.
 *
 * 显示的Lock对象在加锁和释放锁方面，相对于内建的锁来说，还赋予了你更细粒度的控制力，这对于实现专用同步结构是很有用的，
 * 例如：用户遍历链接列表中的"节点的节点传递的加锁机制（锁耦合），这种遍历代码必须在释放当前节点的锁之前捕获下一个节点锁
 */
public class AttempLockingMain {
    public static void main(String[] args) throws InterruptedException {
        final AttemptLocking al = new AttemptLocking();
//        al.untimed();  // True -- lock is available
//        al.timed();    // True -- lock is available

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();

        TimeUnit.SECONDS.sleep(1);
        Thread.yield();
        al.untimed();   // False -- lock grabbed by task
        al.timed();     // False -- lock grabbed by task
    }
}
