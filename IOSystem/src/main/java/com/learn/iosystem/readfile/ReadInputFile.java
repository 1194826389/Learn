package com.learn.iosystem.readfile;

import java.io.*;

/**
 * Created by hechao on 2017/4/18.
 */
public class ReadInputFile {
    public static String filepath = "/Users/hechao/Documents/Learn/IOSystem/Data.txt";
    public static void operation() throws IOException {
//        System.out.println(bufferedInputRead(filepath));
//        memoryInputRead();
//        formattedMemoryInputRead();
//        BasicFileOutput();
//        StoringAndRecoveringData();
        UsingRandomAccessFile();
    }

    // learn BufferedReader,FileReader
    public static String bufferedInputRead(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder stringBuilder = new StringBuilder();
        while ((s = in.readLine()) != null) {
            stringBuilder.append(s + "\n");
        }
        in.close();
        return stringBuilder.toString();
    }


    // learn StringReader
    public static void memoryInputRead() throws IOException {
        StringReader in = new StringReader(bufferedInputRead(filepath));
        int c;
        while ((c = in.read()) != -1) {
            System.out.println((char)c);
        }

    }

    // learn DataInputStream,ByteArrayInputStream
    public static void formattedMemoryInputRead() throws IOException {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream("abc".getBytes()));
//        while (true)
//            System.out.println((char)in.readByte());
        while (in.available() != 0)
            System.out.println((char)in.readByte());

    }

    // learn FileWriter,PrintWriter
    public static void BasicFileOutput() throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(bufferedInputRead(filepath)));
        // 通常会用BufferedWriter将其包装气力啊以缓冲输出，(尝试移除此包装来感受对性能的影响--缓冲往往能显著地增加I/O操作的性能)
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        // PrintWriter中的一个辅助构造器，使得你不必每次洗完创建文本文件并向其其中写入时，都去执行所有的装饰工作。
        // 下面这个构造器仍然是在进行缓存，只是不必自己去实习，遗憾的是，其他常见的写入任务都没有快捷方式，
        // 因此典型的I/O仍旧包含大量的冗余文本，但是在之后的TextFile工具简化了这些常见任务
        PrintWriter out = new PrintWriter("test.out");
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            // 写入test.out文件中
            out.println(lineCount++ + ": " + s);
        }

        out.close();

        // System.out.println(bufferedInputRead("a.out"));
    }

    // learn DataOutputStream,BufferedOutputStream,FileOutputStream,
    public static void StoringAndRecoveringData() throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.text")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.text")));
        System.out.println(in.readDouble());
        // Only readUTF() will recover the java-UTF String properly
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());


    }

    // learn DataOutputStream,BufferedOutputStream,FileOutputStream,
    public static void UsingRandomAccessFile() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(filepath,"rw");
        rf.writeDouble(1.432);
        rf.writeDouble(5.23423);
        rf.writeUTF("bad");
        rf.writeUTF("abc");
        rf.close();
        display();

        rf = new RandomAccessFile(filepath,"rw");
        rf.seek(8*2);
        rf.writeUTF("abc");
        rf.close();
        display();
    }

    private static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(filepath,"r");

        System.out.println("\n");

        System.out.println("Value " + 0 + ": " + rf.readDouble());
        System.out.println("Value " + 1 + ": " + rf.readDouble());
        System.out.println("Value " + 2 + ": " + rf.readUTF());
        System.out.println("Value " + 3 + ": " + rf.readUTF());
        rf.close();
    }



}
