package com.learn.basicthread.endmission.elegantlyendmission;

import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/11.
 */
public class InterruptingIdiomMain {
    public static void main(String[] args) throws  Exception{
        Thread t= new Thread(new BlockedThree());
        t.start();
        // 在设置2030 和2000时结果不一样，因为interrupt可能在在point1-point2之间被调用，也有可能在point2之后（即在for循环中间）调用。
        // try-finally 在需要清理的时候都要使用，在使用Lock时也要使用try-finally
        TimeUnit.MILLISECONDS.sleep(2030);
        t.interrupt();
    }
}
