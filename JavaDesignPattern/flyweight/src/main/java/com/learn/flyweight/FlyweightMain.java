package com.learn.flyweight;

/**
 * Created by hechao on 2017/4/10.
 */
public class FlyweightMain {
    public static void main(String arg[]) {
        int extrinsicstate = 22;
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight fx = factory.GetFlyweight("X");
        fx.Operation(--extrinsicstate);

        Flyweight fy = factory.GetFlyweight("Y");
        fy.Operation(--extrinsicstate);

        Flyweight fz = factory.GetFlyweight("Z");
        fz.Operation(--extrinsicstate);

        Flyweight uf = new UnsharedConcreteFlyweight();
        uf.Operation(--extrinsicstate);

    }
}
