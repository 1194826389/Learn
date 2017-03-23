package com.learn.observer.subject;


import com.learn.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechao on 2017/3/23.
 * 通知者接口
 */
public abstract class Subject {

    private List<Observer> observerList = new ArrayList<>();

    // 增加观察者
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    // 移除观察者
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    // 通知观察者
    public void notifyObservers() {
        for (Observer o: observerList) {
            o.update();
        }
    }

}
