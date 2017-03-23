package com.learn.factory.basicOperation;

import com.learn.factory.Operation;

/**
 * Created by hechao on 2017/3/16.
 */
public class OperationDiv extends Operation {
    public double GetResult() throws Exception {
        double result = 0;
        if (getNumberB() == 0)
            throw new Exception("除数不能为0。");
        result = numberA / numberB;
        return result;
    }
}
