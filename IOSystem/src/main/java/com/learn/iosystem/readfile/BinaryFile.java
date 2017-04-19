package com.learn.iosystem.readfile;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取二进制文件
 * Created by hechao on 2017/4/19.
 */
public class BinaryFile {
    public static String file = "/Users/hechao/Documents/Learn/IOSystem/Data.txt";
    public static void operation() throws IOException {
        read(file);
    }


    public static byte[] read(File file) throws IOException{
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data = new byte[bf.available()];
            System.out.println(data.toString());
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }
    public static byte[] read(String file) throws IOException {
        return read(new File(file).getAbsoluteFile());
    }
}
