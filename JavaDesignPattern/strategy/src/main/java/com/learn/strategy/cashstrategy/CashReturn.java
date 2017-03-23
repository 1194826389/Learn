package com.learn.strategy.cashstrategy;

/**
 * Created by hechao on 2017/3/17.
 */
public class CashReturn extends CashSuper {

    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;
    public CashReturn(String moneyCondition,String moneyReturn) {
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }

    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition)
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        return result;
    }
}
