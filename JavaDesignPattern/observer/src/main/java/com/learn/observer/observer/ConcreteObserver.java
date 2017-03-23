package com.learn.observer.observer;

import com.learn.observer.subject.ConcreteSubject;

/**
 * Created by hechao on 2017/3/23.
 */
public class ConcreteObserver extends Observer {

private String name;
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject,String name){
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.print("观察者" + name +"的状态是" + observerState);

    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}
