package com.learn.state.statelist;

import com.learn.state.StateContext;

/**
 * Created by hechao on 2017/3/19.
 */
public class NoonState extends State{
    public void writeProgram(StateContext context) {
        double currentHour = context.getHour();
        if (currentHour < 13) {
            System.out.print("当前时间:" + currentHour + "点 午饭时间到，犯困，午休。\n");
        } else {
            context.setCurrentState(new AfternoonState());
            context.writeProgram(currentHour);
        }
    }
}
