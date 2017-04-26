package com.learn.iosystem.nio;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by hechao on 2017/4/23.
 */
public class GetChannel {
    private static final  int BSIZE = 1024;
    public static void operation() throws IOException {
//        GetChannel();
        ChannelCopy();
    }

    public static void GetChannel() throws IOException {
        try {
            // write a file
            FileChannel fc = new FileOutputStream("Data.txt").getChannel();
            fc.write(ByteBuffer.wrap("Some more".getBytes()));
            fc.close();
            // Add to the end of the file
            fc = new RandomAccessFile("Data.txt","rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("some more".getBytes()));
            fc.close();

            // Read a file
            fc = new FileInputStream("Data.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            fc.read(buff);
            // 一旦调用read()来告知FileChannel向ByteBuffer存储字节，就必须调用缓冲器上的flip(),让它做好让别人读取字节的准备。如果我们打算使用缓冲器执行进一步的read()操作，我们也必须得调用clear()来为每个read做好准备。
            buff.flip();
            while (buff.hasRemaining()) {
                System.out.println((char) buff.get());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void ChannelCopy() throws IOException {
        FileChannel in = new FileInputStream("Data.txt").getChannel();
        FileChannel out = new FileOutputStream("Data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        // 一旦调用read()来告知FileChannel向ByteBuffer存储字节，就必须调用缓冲器上的flip(),让它做好让别人读取字节的准备。如果我们打算使用缓冲器执行进一步的read()操作，我们也必须得调用clear()来为每个read做好准备。
//        while (in.read(buffer) != -1) {
//            buffer.flip(); // Prepare for writing
//            out.write(buffer);
//            buffer.clear();  // Prepare for reading
//        }

        // 特殊方法transferTo() 和 transferFrom() 则允许我们将一个通道和另外一个通道直接相连。
        in.transferTo(0,in.size(),out);
        // 或者 out.transferFrom(in,0,in.size());
    }

}
