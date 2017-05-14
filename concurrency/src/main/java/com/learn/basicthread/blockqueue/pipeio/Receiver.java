package com.learn.basicthread.blockqueue.pipeio;

import java.io.IOException;
import java.io.PipedReader;
import java.util.Random;

/**
 * Created by hechao on 2017/5/14.
 */
public class Receiver implements Runnable {

    private PipedReader in;
    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 阻塞直到字母
                System.out.println("Read: " + (char)in.read() + ", ");
            }
        } catch (IOException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}
