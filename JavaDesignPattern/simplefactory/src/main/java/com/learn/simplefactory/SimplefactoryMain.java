package com.learn.simplefactory;

/**
 * Created by hechao on 2017/3/17.
 */
public class SimplefactoryMain {
    public static void main(String arg[]) {
        Operation oper = null;
        try {
            oper = OperationFactory.CreateOperation(OperationType.ADD.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        oper.numberA = 1;
        oper.numberB = 2;
        try {
            double result = oper.GetResult();
            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
