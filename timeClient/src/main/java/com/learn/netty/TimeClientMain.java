package com.learn.netty;

/**
 * Created by hechao on 2017/4/23.
 */
public class TimeClientMain {
    public static void main(final String args[]) {
        int ServerPort = 4020;

        // Netty Client
        try {
            new TimeClient().connect(ServerPort,"127.0.0.1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
