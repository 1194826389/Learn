package com.learn.simplefactory;

/**
 * Created by hechao on 2017/3/16.
 */
public enum OperationType {
    ADD("OperationAdd"),
    SUB("OperationSub"),
    MUL("OperationMul"),
    DIV("OperationDiv");

    private String className;
    OperationType(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "com.learn.simplefactory.basicOperation." + this.className;
    }
}
