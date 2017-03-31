package com.learn.command.exampleFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public abstract class Command {

    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    abstract public void executeCommand();
}
