package com.learn.simplefactory.basicOperation;

import com.learn.simplefactory.Operation;

/**
 * Created by hechao on 2017/3/16.
 */
public class OperationSub extends Operation {
    public double GetResult() {
        double result = 0;
        result = getNumberA() - getNumberB();
        return result;
    }
}
