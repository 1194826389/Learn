package com.learn.singleton.hungryload;

/**
 * Created by hechao on 2017/3/28.
 */
public final class BSingleton {
    private static final BSingleton instance = new BSingleton();
    private BSingleton() {}

    public static BSingleton getInstance() {
        return instance;
    }
}
