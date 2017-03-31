package com.learn.command.exampleFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public class BakeMuttonCommand extends Command {
    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    public void executeCommand() {
        receiver.BakeMutton();
    }

    @Override
    public String toString() {
        return "BakeMutton";
    }
}
