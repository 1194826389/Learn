package com.learn.iosystem.standandio;

import java.io.*;

/**
 * Created by hechao on 2017/4/21.
 */
public class Redirecting {
    public static void operation() throws IOException {
        PrintStream console = System.out;
        // I/O重定向操纵的是字节流，而不是字符流，因此我们使用的是InputStream和OutStream,而不是Reader和Writer.
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("Data.txt"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.txt")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }
}
