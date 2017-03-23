package com.learn.statemachine;

import java.util.Random;

/**
 * Created by hechao on 2017/3/19.
 */
public enum Input {
    // money
    NICKEL(5),//五分钱美元
    DIME(10),//1角硬币美元
    QUARTER(25),//2角五分美元
    DOLLAR(100),//1美元
    // item
    TOOTHPASTE(200),//牙膏
    CHIPS(75),//土豆条
    SODA(100),//苏打水
    SOAP(50),//肥皂

    ABORT_TRANSACTION{//瞬间状态
        public int amount(){
            throw new RuntimeException("ABORT.amount");
        }
    },
    STOP{//停止
        public int amount(){
            throw new RuntimeException("ABORT.amount");
        }
    };


    private int value;
    Input(int value) {
        this.value = value;
    }
    Input() {

    }

    int amount() {
        return value;
    }

    static Random random = new Random(47);
    public static Input randomSelection() {
        // Don't iinclude STOP
        return values()[random.nextInt(values().length - 1)];
    }
}
