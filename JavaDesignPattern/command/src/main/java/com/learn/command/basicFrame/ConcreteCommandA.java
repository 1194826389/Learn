package com.learn.command.basicFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public class ConcreteCommandA extends Command {


    public ConcreteCommandA(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
