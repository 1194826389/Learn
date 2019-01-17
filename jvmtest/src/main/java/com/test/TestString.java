package com.test;

/**
 * Created by hechao on 2017/5/3.
 */
public class TestString {
    public void testStringBuffer() {
        long starttime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<10000;i++){

            sbf.append(i);

        }
        long endtime = System.currentTimeMillis();
        System.out.println("time:" + (endtime - starttime));
    }

    public void testString() {
        long starttime = System.currentTimeMillis();
        String str = new String();
        String s = "Hello";
        System.out.println(s.hashCode());
//        s = s + "world!";
//        System.out.println(s.hashCode());

        String s1 = new String("Hello");
        System.out.println(s1.hashCode());


        for(int i=0;i<10000;i++){

            str = str + i;

        }

        long endtime = System.currentTimeMillis();
        System.out.println("time:" + (endtime - starttime));
    }



}
