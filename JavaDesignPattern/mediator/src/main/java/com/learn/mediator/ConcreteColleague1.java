package com.learn.mediator;

/**
 * Created by hechao on 2017/4/6.
 */
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message,this);
    }

    public void notifyMediator(String message) {
        System.out.println("同事1得到消息: " + message);
    }
}
