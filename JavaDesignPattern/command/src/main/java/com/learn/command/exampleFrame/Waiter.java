package com.learn.command.exampleFrame;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * Created by hechao on 2017/3/31.
 */
public class Waiter {
    private Command command;
    private List<Command> orders = new ArrayList<Command>();

    public void setOrder(Command command) {

        if (command.toString().equals("BakeChickenWing")) {
            System.out.println("服务员：鸡翅没有了，请点逼得烧烤");
        } else {
            orders.add(command);
            System.out.println("增加订单：" + command.toString() + " 时间：" + new Date());
        }
        this.command = command;
    }


    public void cancelOrder(Command command) {
        orders.remove(command);
        System.out.println("取消订单：" + command.toString() + " 时间：" + new Date());
    }

    public void notifyBarbecuer() {
        for (Command cmd:orders) {
            cmd.executeCommand();
        }
    }
}
