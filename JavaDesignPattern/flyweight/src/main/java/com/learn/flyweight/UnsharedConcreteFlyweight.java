package com.learn.flyweight;

/**
 * Created by hechao on 2017/4/10.
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    public void Operation(int extrinsicstate) {
        System.out.println("不共享的具体Flyweight: " + extrinsicstate);
    }
}
