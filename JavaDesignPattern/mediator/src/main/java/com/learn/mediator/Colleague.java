package com.learn.mediator;

/**
 * Created by hechao on 2017/4/6.
 */
public abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
}
