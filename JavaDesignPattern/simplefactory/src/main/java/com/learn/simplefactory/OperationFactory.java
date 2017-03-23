package com.learn.simplefactory;

/**
 * Created by hechao on 2017/3/16.
 */
public class OperationFactory {
    public static Operation CreateOperation(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


//          用反射机制和switch分支说byebye
        return (Operation) Class.forName(className).newInstance();

////        switch 方式
//        Operation operation = null;
//        switch (operationType) {
//            case ADD:
//                operation = new OperationAdd();
//                break;
//            case SUB:
//                operation = new OperationSub();
//                break;
//            case MUL:
//                operation = new OperationMul();
//                break;
//            case DIV:
//                operation = new OperationDiv();
//                break;
//        }
//        return operation;

    }

}
