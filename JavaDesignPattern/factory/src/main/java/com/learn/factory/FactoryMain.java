package com.learn.factory;

import com.learn.factory.OperationFactory.DivFactory;

/**
 * Created by hechao on 2017/3/17.
 */
public class FactoryMain {
    public static void main(String arg[]) {
        IFactory operationFactory = new DivFactory();
        Operation oper = operationFactory.CreateOperation();
        oper.numberA = 1;
        oper.numberB = 0;
        try {
            double result = oper.GetResult();
            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
