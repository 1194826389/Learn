package com.learn.observer;

import com.learn.observer.observer.ConcreteObserver;
import com.learn.observer.subject.ConcreteSubject;

/**
 * Created by hechao on 2017/3/23.
 */
public class ObserverMain {
    public static void main(String arg[]) {
        //ConcreteObserver 相当于通知中心
        ConcreteSubject s = new ConcreteSubject();



        s.attach(new ConcreteObserver(s,"X"));
        s.attach(new ConcreteObserver(s,"Y"));
        s.attach(new ConcreteObserver(s,"Z"));


        s.setSubjectState("ABC");
        s.notifyObservers();


    }
}
