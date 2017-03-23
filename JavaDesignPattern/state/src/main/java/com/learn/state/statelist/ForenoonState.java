package com.learn.state.statelist;

import com.learn.state.StateContext;

/**
 * Created by hechao on 2017/3/19.
 */
public class ForenoonState extends State{
    public void writeProgram(StateContext context) {

        double currentHour = context.getHour();
        if (currentHour < 12) {
            System.out.print("当前时间:" + currentHour + "点 上午工作，精神百倍\n");
        } else {
            context.setCurrentState(new NoonState());
            context.writeProgram(currentHour);
        }
    }
}
