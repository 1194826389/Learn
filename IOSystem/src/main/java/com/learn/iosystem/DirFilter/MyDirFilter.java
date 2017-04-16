package com.learn.iosystem.DirFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by hechao on 2017/4/16.
 */
public class MyDirFilter {
    public static MyDirFilter operation(final String[] args) {
        File path = new File("..");
        // 0 = {File@423} "../.DS_Store"
        // 1 = {File@424} "../.git"
        // 2 = {File@425} "../.gitignore"
        // 3 = {File@426} "../.idea"
        // 4 = {File@427} "../IOSystem"
        // 5 = {File@428} "../JavaDesignPattern"
        // 6 = {File@429} "../README.md"
        String[] list;
        if (args.length == 0) {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(".git(.*)");
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        } else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);

        for (String dirItem:list) {
            System.out.println(dirItem);

        }
        return null;
    }
}
