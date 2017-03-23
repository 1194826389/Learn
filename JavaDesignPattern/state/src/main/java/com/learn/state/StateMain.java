package com.learn.state;

import com.learn.state.statelist.ForenoonState;

/**
 * Created by hechao on 2017/3/19.
 */
public class StateMain {
    public static void main(String arg[]) {
        // 工作状态的例子--大话设计模式
        StateContext stateContext = new StateContext(new ForenoonState());
        stateContext.writeProgram(9.0);
        stateContext.writeProgram(10.0);
        stateContext.writeProgram(11.0);
        stateContext.writeProgram(12.0);
        stateContext.writeProgram(13.0);
        stateContext.writeProgram(14.0);
        stateContext.writeProgram(15.0);
        stateContext.writeProgram(16.0);
        stateContext.writeProgram(18.0);
        stateContext.writeProgram(20.0);
        stateContext.writeProgram(23.0);
        stateContext.writeProgram(24.0);

    }
}
