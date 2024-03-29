package com.learn.iosystem.readfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by hechao on 2017/4/19.
 */
public class TextFile extends ArrayList<String> {


    public static void operation() {
        String file = read("Data.txt");
        write("test.txt",file);

        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");

        TreeSet<String> words = new TreeSet<String>(new TextFile("Data.txt","\\W+"));
        System.out.println(words.headSet("a"));
    }

    // Read a file as a single string
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    // Write a single string in one methond call
    public static void write(String fileName,String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName,String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }


    // 正常通过行来读取
    public TextFile(String fileName) {
        this(fileName,"\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item:this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





}
