package com.learn.state.statelist;

import com.learn.state.StateContext;

/**
 * Created by hechao on 2017/3/19.
 */
public class AfternoonState extends State{
    public void writeProgram(StateContext context) {
        double currentHour = context.getHour();
        if (currentHour < 17) {
            System.out.print("当前时间:" + currentHour + "点 下午状态还不错，继续努力。\n");
        } else {
            context.setCurrentState(new EveningState());
            context.writeProgram(currentHour);
        }
    }
}
