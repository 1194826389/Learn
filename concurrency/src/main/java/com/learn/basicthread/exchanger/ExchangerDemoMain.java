package com.learn.basicthread.exchanger;

import com.learn.basicthread.semaphore.sampleone.Fat;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by hechao on 2017/5/8.
 *
 Exchanger的作用是作为一个同步点，线程通过它可以配对交换数据。

 每个线程可以通过exchange方法来传递想要传递的数据，并且返回时接受其他线程传递的数据。一个Exchanger可以看做是双向的SynchronousQueue，经常在遗传算法和管道设计中使用。

 */
public class ExchangerDemoMain {
    static int size = 10;
    static int delay = 100; // Seconds

    public static void main(String[] arg) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<Fat>(),
                consumerList = new CopyOnWriteArrayList<Fat>();

        exec.execute(new ExchangerProducer<Fat>(xc,BasicGenerator.create(Fat.class),producerList));
        exec.execute(new ExchangerProducerTwo<Fat>(xc,BasicGenerator.create(Fat.class),producerList));
        exec.execute(new ExchangerConsumer<Fat>(xc,consumerList));
        TimeUnit.MILLISECONDS.sleep(delay);
        exec.shutdownNow();

    }
}
