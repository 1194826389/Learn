package com.learn.basicthread.endmission.interruptendmission;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hechao on 2017/5/11.
 */
public class IOBlocked implements Runnable{

    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }
    @Override
    public void run() {

        try {
            System.out.println("Waiting for read(): ");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted form blocked I/O");
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
