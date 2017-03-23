package com.learn.state.statelist;

import com.learn.state.StateContext;

/**
 * Created by hechao on 2017/3/19.
 */
public class SleepingState extends State{
    public void writeProgram(StateContext context) {
        System.out.print("当前时间:" + context.getHour() + "点 不行了，要睡觉了。\n");
    }
}
