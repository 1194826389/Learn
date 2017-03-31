package com.learn.decorator;

/**
 * Created by hechao on 2017/3/30.
 */
public class ConcreteDecoratorA extends Decorator {
    private String addedState;

    @Override
    public void Operation() {
        super.Operation();
        addedState = "com.learn.decorator.Decorator function";
        System.out.println("具体修饰对象A的操作");
    }
}
