package com.learn.factory.basicOperation;

import com.learn.factory.Operation;

/**
 * Created by hechao on 2017/3/16.
 */
public class OperationMul extends Operation {
    public double GetResult() {
        double result = 0;
        result = numberA * numberB;
        return result;
    }
}
