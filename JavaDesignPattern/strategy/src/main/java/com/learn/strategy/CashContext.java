package com.learn.strategy;

import com.learn.strategy.cashstrategy.CashNormal;
import com.learn.strategy.cashstrategy.CashRebate;
import com.learn.strategy.cashstrategy.CashReturn;
import com.learn.strategy.cashstrategy.CashSuper;

/**
 * Created by hechao on 2017/3/17.
 */
public class CashContext {
    private CashSuper cashSuper;
    public CashContext(CashStrategyType cashStrategyType) {
        switch (cashStrategyType) {
            case NORMAL:
                cashSuper = new CashNormal();
                break;
            case REBATE:
                cashSuper = new CashRebate("0.8");
                break;
            case RETURN:
                cashSuper = new CashReturn("300","100");
                break;
        }
    }

    public double GetResult(double money) {
        return this.cashSuper.acceptCash(money);
    }
}
