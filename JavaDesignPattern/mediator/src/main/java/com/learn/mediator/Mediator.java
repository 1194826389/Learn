package com.learn.mediator;

/**
 * Created by hechao on 2017/4/6.
 */
public abstract class Mediator {
    public abstract void send(String message,Colleague colleague);
}
