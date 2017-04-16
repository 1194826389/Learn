package com.learn.iosystem.DirTree;

/**
 * Created by hechao on 2017/4/16.
 */
public class MyDirTree {

    public static void operation(final String[] args) {
        if (args.length == 0) {
            System.out.println(Directory.walk("."));
        } else {
            for (String arg:args) {
                System.out.println(Directory.walk(arg));
            }
        }
    }


}
