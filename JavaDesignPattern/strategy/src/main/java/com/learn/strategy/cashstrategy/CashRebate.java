package com.learn.strategy.cashstrategy;

/**
 * Created by hechao on 2017/3/17.
 */
public class CashRebate extends CashSuper {

    public double moneyRebate = 1d;
    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }
    public double acceptCash(double money) {
        return money * moneyRebate;

    }
}
