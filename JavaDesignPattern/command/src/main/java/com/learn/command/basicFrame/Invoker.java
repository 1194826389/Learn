package com.learn.command.basicFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

