package com.learn.strategy;

/**
 * Created by hechao on 2017/3/17.
 */
public class StrategyMain {
    public static void main(String arg[]) {
        // combine strategy and simple factory
        CashContext cashContext =new CashContext(CashStrategyType.REBATE);
        System.out.print(cashContext.GetResult(200));
    }
}
