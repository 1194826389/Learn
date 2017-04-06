package com.learn.mediator;

/**
 * Created by hechao on 2017/4/6.
 */
public class ConcreteMediator extends Mediator {

    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == colleague2) {
            colleague1.notifyMediator(message);
        } else {
            colleague2.notifyMediator(message);
        }
    }

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }
}
