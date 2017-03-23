package com.learn.factory.OperationFactory;

import com.learn.factory.IFactory;
import com.learn.factory.Operation;
import com.learn.factory.basicOperation.OperationSub;

/**
 * Created by hechao on 2017/3/17.
 */
public class SubFactory implements IFactory {

    public Operation CreateOperation() {
        return new OperationSub();
    }
}
