package com.learn.statemachine;

/**
 * Created by hechao on 2017/3/20.
 */
public class RandomInputGenerator implements Generator<Input> {
    public Input next() {
        return Input.randomSelection();
    }
}
