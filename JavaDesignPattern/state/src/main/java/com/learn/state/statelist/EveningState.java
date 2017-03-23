package com.learn.state.statelist;

import com.learn.state.StateContext;

/**
 * Created by hechao on 2017/3/19.
 */
public class EveningState extends State{
    public void writeProgram(StateContext context) {
        double currentHour = context.getHour();
        if (currentHour < 21) {
            System.out.print("当前时间:" + currentHour + "点 加班哦，疲惫至极\n");
        } else {
            context.setCurrentState(new SleepingState());
            context.writeProgram(currentHour);
        }
    }
}
