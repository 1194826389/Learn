package com.learn.observer.subject;

import com.learn.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechao on 2017/3/23.
 */
public class ConcreteSubject extends Subject {

    private List<Observer> observerList = new ArrayList<>();
    private String action;
    private String subjectState = null;



    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observerList) {
            o.update();
        }
    }


    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
