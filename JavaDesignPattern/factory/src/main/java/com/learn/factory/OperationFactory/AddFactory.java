package com.learn.factory.OperationFactory;

import com.learn.factory.IFactory;
import com.learn.factory.Operation;
import com.learn.factory.basicOperation.OperationAdd;

/**
 * Created by hechao on 2017/3/17.
 */
public class AddFactory implements IFactory {

    public Operation CreateOperation() {
        return new OperationAdd();
    }
}
