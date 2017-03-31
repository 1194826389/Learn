package com.learn.decorator;

/**
 * Created by hechao on 2017/3/30.
 */
public class DecoratorMain {
    public static void main(String arg[]) {

        // com.learn.decorator.ConcretComponent 属于核心功能类
        ConcretComponent c = new ConcretComponent();

        // com.learn.decorator.ConcreteDecoratorA 和 com.learn.decorator.ConcreteDecoratorB 属于修饰类
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.Operation();
    }
}
