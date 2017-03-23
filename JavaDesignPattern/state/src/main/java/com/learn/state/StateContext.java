package com.learn.state;

import com.learn.state.statelist.State;

/**
 * Created by hechao on 2017/3/19.
 */
public class StateContext {
    private State currentState;
    private double hour;


    public StateContext(State state) {
        this.currentState = state;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void writeProgram(double hour) {
        this.hour = hour;
        currentState.writeProgram(this);

    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }
}
