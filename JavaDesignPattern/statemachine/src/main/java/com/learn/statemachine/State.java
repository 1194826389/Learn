package com.learn.statemachine;

/**
 * Created by hechao on 2017/3/19.
 */
public enum State {
    RESTING{
        void next(Input input){
            switch (Category.categorize(input)) {
                case MONEY:
                    amount += input.amount();
                    state = ADDING_MONEY;
                    break;
                case SHUT_DOWN:
                    state = TERMINAL;
                default:
            }
        }
    },

    ADDING_MONEY{
        void next(Input input){
            switch (Category.categorize(input)) {
                case MONEY:
                    amount += input.amount();
                    break;
                case ITEM_SELCTION:
                    selection = input;
                    if (amount < selection.amount()) {
                        System.out.print("Insufficient money for " + selection + "(" + selection.amount() + ")" + " ");
                    }else {
                        state = DISPENSING;
                    }
                    break;
                case QUIT_TRANSACTION:
                    state = GIVING_CHANGE;
                    break;
                case SHUT_DOWN:
                    state = TERMINAL;

            }
        }
    },

    DISPENSING(StateDuration.TRANSIENT) {
        void next(){
            System.out.print("here is your " + selection + "\n");
            amount -= selection.amount();
            state = GIVING_CHANGE;
        }
    },

    GIVING_CHANGE (StateDuration.TRANSIENT) {
        void next(){
            if (amount > 0) {
                System.out.print("-----Your change: " + amount + " 接着钱从钱口出来 ");
                amount = 0;
            }
            state = RESTING;
        }
    },

    TERMINAL{
        void output() {
            System.out.print("Halted");
        }
    };

    private static int amount = 0;// 总额
    public static State state = State.RESTING;
    private static Input selection = null; // 选购的商品
    public boolean isTransient = false;// 是否要停顿



    enum StateDuration {TRANSIENT}



    State() {

    }

    State(StateDuration trans) {
        isTransient = true;
    }

    void next(Input input) {
        throw new RuntimeException("Only call next(Input input) for non-transient states");
    }

    void next() {
        throw new RuntimeException("Only call next() for StateDuration.TRANSIENT states");
    }

    void output() {
        System.out.print("amout = " + amount);
    }




}
