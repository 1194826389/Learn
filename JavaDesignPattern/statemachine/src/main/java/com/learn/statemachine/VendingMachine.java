package com.learn.statemachine;


/**
 * Created by hechao on 2017/3/19.
 */
public class VendingMachine {
    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        run(gen);
    }

    // 生成器类找不到
    static void run(Generator<Input> gen) {
        int i = 0;
        while (State.state != State.TERMINAL && i++ < 10 ) {
            Input input = gen.next();
            System.out.print(input + " ");
            State.state.next(input);// 根据input的类型，改变状态
            while (State.state.isTransient) {
                State.state.next();
            }
            State.state.output();
            System.out.print("\n");
        }
    }

}
