package com.learn.command.exampleFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public class BakeChickenWingCommand extends Command {
    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    public void executeCommand() {
        receiver.BakeChickenWing();
    }

    @Override
    public String toString() {
        return "BakeChickenWing";
    }
}
