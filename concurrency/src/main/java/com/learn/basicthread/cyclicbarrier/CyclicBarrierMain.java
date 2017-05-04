package com.learn.basicthread.cyclicbarrier;

/**
 * Created by hechao on 2017/5/3.
 *
 * CyclicBarrier适合这种情况：你希望创建一组任务，他们并行的执行工作，在进行下一个步骤之前等待，
 * 然后所有任务都完成之后，才进行下一个步骤。它使得所有的并行任务都将在栅栏处列队，
 * 因此可以一致的向前移动。
 *
 * 这非常像CountDownLatch，只不过CountDownLatch是只触发一次的事件，而CyclicBarrier可以多次重用。
 * 此外，还有一个区别就是 可以向CyclicBarrier提供一个"栅栏动作"，它是Runnable,当计数值到达0时自动执行
 *
 */
public class CyclicBarrierMain {
    public static void main(String[] args) {
        int mhorses = 7;
        int pause = 200;
        new HorseRace(mhorses,pause);
    }
}
