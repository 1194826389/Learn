package com.learn.decorator;

/**
 * Created by hechao on 2017/3/30.
 */
public class ConcreteDecoratorB extends Decorator {
    private String addedState;

    @Override
    public void Operation() {
        super.Operation();
        AddedBehavior();
        System.out.println("具体修饰对象B的操作");
    }

    private void AddedBehavior() {

    }
}
