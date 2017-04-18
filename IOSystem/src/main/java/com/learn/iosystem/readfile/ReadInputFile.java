package com.learn.iosystem.readfile;

import java.io.*;

/**
 * Created by hechao on 2017/4/18.
 */
public class ReadInputFile {
    public static String filepath = "/Users/hechao/Documents/Learn/IOSystem/src/main/java/com/learn/iosystem/readfile/ReadInputFile.java";
    public static void operation() throws IOException {
//        System.out.println(bufferedInputRead(filepath));
//        memoryInputRead();
//        formattedMemoryInputRead();
        BasicFileOutput();
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

    public static void BasicFileOutput() throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(bufferedInputRead(filepath)));
        //通常会用BufferedWriter将其包装气力啊以缓冲输出，(尝试移除此包装来感受对性能的影响--缓冲往往能显著地增加I/O操作的性能)
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            // 写入test.out文件中
            out.println(lineCount++ + ": " + s);
        }

        out.close();

//        System.out.println(bufferedInputRead("a.out"));
    }



}
