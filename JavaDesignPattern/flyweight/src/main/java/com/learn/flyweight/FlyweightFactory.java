package com.learn.flyweight;

import java.util.HashMap;

/**
 * Created by hechao on 2017/4/10.
 */
public class FlyweightFactory {
    private HashMap<String, ConcreteFlyweight> flyweights = new HashMap<String, ConcreteFlyweight>();

    public FlyweightFactory() {
        flyweights.put("X",new ConcreteFlyweight());
        flyweights.put("Y",new ConcreteFlyweight());
        flyweights.put("Z",new ConcreteFlyweight());

    }

    public Flyweight GetFlyweight(String key) {
        return (flyweights.get(key));
    }
}
