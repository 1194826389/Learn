package com.learn.iosystem;

import com.learn.iosystem.DirCheckOrMake.MakeDirectories;
import com.learn.iosystem.DirTree.Directory;
import com.learn.iosystem.DirTree.DirectoryDemo;
import com.learn.iosystem.DirTree.MyDirTree;

/**
 * Created by hechao on 2017/4/16.
 */
public class IOSystemMain {
    public static void main(final String args[]) {
        // test DirFileter
//        MyDirFilter.operation(args);
//        MyDirTree.operation(args);
//        DirectoryDemo.operation();

        MakeDirectories.operation(args);

    }
}
