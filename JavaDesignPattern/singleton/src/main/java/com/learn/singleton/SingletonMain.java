package com.learn.singleton;

import com.learn.singleton.hungryload.BSingleton;
import com.learn.singleton.lazyload.ASingleton;

/**
 * Created by hechao on 2017/3/28.
 */
public class SingletonMain {

    public static void main(String arg[]) {
        // 懒汉加载
        ASingleton s1 = ASingleton.getInstance();
        ASingleton s2 = ASingleton.getInstance();
        if (s1 == s2) {
            System.out.print(s1.hashCode() +  "-----" + s2.hashCode());
            System.out.print("\n两个A单例对象相等\n");
        }

        // 饿汉加载
        BSingleton s3 = BSingleton.getInstance();
        BSingleton s4 = BSingleton.getInstance();
        if (s3 == s4) {
            System.out.print(s3.hashCode() +  "-----" + s4.hashCode());
            System.out.print("\n两个B单例对象相等\n");
        }
    }

}
