package com.learn.iosystem;

import com.learn.iosystem.readfile.ReadInputFile;

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
            ReadInputFile.operation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
