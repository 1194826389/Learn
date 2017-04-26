package com.learn.iosystem.standandio;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hechao on 2017/4/21.
 */
public class ChangeSystemOut {
    public static void operation() throws IOException {
        PrintWriter out = new PrintWriter(System.out,true);
        out.println("hello world");
    }
}
