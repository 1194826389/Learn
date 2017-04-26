package com.learn.iosystem;

import com.learn.iosystem.netty.TimeClient;
import com.learn.iosystem.netty.TimeServer;
import com.learn.iosystem.nio.GetChannel;
import com.learn.iosystem.processcontroller.OSExecute;
import com.learn.iosystem.standandio.Redirecting;

/**
 * Created by hechao on 2017/4/16.
 */
public class IOSystemMain {
    public static void main(final String args[]) {

        try {
            // test DirFileter
//        MyDirFilter.operation(args);
//        MyDirTree.operation(args);
//        DirectoryDemo.operation();
//        MakeDirectories.operation(args);
//        ReadInputFile.operation();
//        TextFile.operation();
//        BinaryFile.operation();
//        Echo.operation();
//        ChangeSystemOut.operation();
//        Redirecting.operation();
//        OSExecute.operation();
//        GetChannel.operation();



            // Netty Server
            int ServerPort = 4020;
            new TimeServer().bind(ServerPort);
//
//            // Netty Client
//            new TimeClient().connect(ServerPort,"127.0.0.1");


        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


    }
}
