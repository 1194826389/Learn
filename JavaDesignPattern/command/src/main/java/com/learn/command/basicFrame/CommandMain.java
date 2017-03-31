package com.learn.command.basicFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public class CommandMain {
    public static void main(String arg[]) {


        // 请求操作
        Receiver r = new Receiver();
        Command commandA = new ConcreteCommandA(r);
        Command commandB = new ConcreteCommandB(r);
        Invoker i = new Invoker();

        // 执行操作
        i.setCommand(commandA);
        i.executeCommand();
        i.setCommand(commandB);
        i.executeCommand();

    }
}
