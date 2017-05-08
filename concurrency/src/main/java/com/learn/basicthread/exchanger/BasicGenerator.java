package com.learn.basicthread.exchanger;

/**
 * Created by hechao on 2017/5/8.
 */
public class BasicGenerator<T> implements Generator<T>{
    private Class<T> type;
    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}
