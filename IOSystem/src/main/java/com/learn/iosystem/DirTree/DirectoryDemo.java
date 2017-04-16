package com.learn.iosystem.DirTree;

import com.learn.iosystem.DirTree.Directory;
import com.learn.iosystem.DirTree.PPrint;

import java.io.File;

/**
 * Created by hechao on 2017/4/16.
 */
public class DirectoryDemo {

    public static void operation() {
        // 所有目录
        System.out.println("-------------------所有目录----------------------");
        PPrint.pprint(Directory.walk(".").dirs);
        // 所有以T开头的文件
        System.out.println("--------------在当前目录层级的所有以I开头的文件--------------------");
        for (File file:Directory.local(".","I.*")) {
            System.out.println(file);
        }
        // 所有以T开头的java文件
        System.out.println("--------------所有以D开头的java文件----------------");
        for (File file: Directory.walk(".","D.*\\.java")) {
            System.out.println(file);
        }

        // 所有以T开头的类文件
        System.out.println("--------------所有以D开头的类文件-------------------");
        for (File file: Directory.walk(".","D.*\\.java")) {
            System.out.println(file);
        }

        // 所有包含z或者Z的文件
        System.out.println("--------------所有包含Y或者y的文件------------------");
        for (File file: Directory.walk(".",".*[Yy].*\\.class")) {
            System.out.println(file);
        }
    }

}
