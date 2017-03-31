package com.learn.command.exampleFrame;

/**
 * Created by hechao on 2017/3/31.
 */
public class CommandMain {
    public static void main(String arg[]) {

        // 开店前的准备
        Barbecuer boy = new Barbecuer();
        Command bakeChickenWingCommand = new BakeChickenWingCommand(boy);
        Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);
        Command bakeMuttonCommand2 = new BakeMuttonCommand(boy);
        Waiter girl = new Waiter();


        // 开门营业 客户发出请求
        girl.setOrder(bakeChickenWingCommand);
        girl.setOrder(bakeMuttonCommand1);
        girl.setOrder(bakeMuttonCommand2);

        // 老板知道了，去做烧烤了
        girl.notifyBarbecuer();



    }
}
