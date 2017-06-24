package com.learn.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hechao on 2017/5/22.
 */
public class test extends HashMap{


    public static void main(String[] args) {
//        Long j=CastUtil.cast(Long.class,123);
//        System.out.println(j.getClass());

//        System.out.println(j);

    }

    public static Map getInstance() {
        return new HashMap();
    }

    public static class CastUtil  {
        public static  <T> T cast(Class<T> clazz,Object t) {
            synchronized (CastUtil.class) {
                T object = (T) t;
                System.out.println(t.getClass());
                System.out.println("Cast finish");
                return object;
            }
        }
    }


    public synchronized void method() {
        System.out.println("Hello World!");
    }

    public void method1() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }


}


