package com.learn.simplefactory;

/**
 * Created by hechao on 2017/3/16.
 */
public abstract class Operation {
    public double numberA = 0;
    public double numberB = 0;


    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public abstract double GetResult() throws Exception;
}
