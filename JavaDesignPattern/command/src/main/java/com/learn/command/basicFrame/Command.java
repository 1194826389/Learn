package com.learn.command.basicFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public abstract class Command {
    protected Receiver receiver;
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    abstract public void execute();
}
