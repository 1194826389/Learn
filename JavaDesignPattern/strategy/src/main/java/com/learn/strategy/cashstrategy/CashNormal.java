package com.learn.strategy.cashstrategy;

/**
 * Created by hechao on 2017/3/17.
 */
public class CashNormal extends CashSuper {

    public double acceptCash(double money) {
        return money;
    }
}
