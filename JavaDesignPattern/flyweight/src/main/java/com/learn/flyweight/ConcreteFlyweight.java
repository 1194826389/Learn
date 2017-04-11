package com.learn.flyweight;

/**
 * Created by hechao on 2017/4/10.
 */
public class ConcreteFlyweight extends Flyweight{
    public void Operation(int extrinsicstate) {
        System.out.println("具体Flyweight: " + extrinsicstate);
    }
}
