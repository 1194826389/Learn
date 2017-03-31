package com.learn.command.basicFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public class ConcreteCommandB extends Command {


    public ConcreteCommandB(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
