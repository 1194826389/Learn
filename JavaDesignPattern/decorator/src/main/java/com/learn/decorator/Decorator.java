package com.learn.decorator;

/**
 * Created by hechao on 2017/3/30.
 */
public abstract class Decorator extends Component{
    private Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void Operation() {
        if (component != null) {
            component.Operation();
        }
    }


}
