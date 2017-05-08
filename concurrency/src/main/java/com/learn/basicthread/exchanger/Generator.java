package com.learn.basicthread.exchanger;

/**
 * Created by hechao on 2017/5/8.
 */
public interface Generator<T> {
    T next();
}
