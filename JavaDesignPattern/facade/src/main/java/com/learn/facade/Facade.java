package com.learn.facade;

import com.learn.facade.SubSystem.SubSystemFour;
import com.learn.facade.SubSystem.SubSystemOne;
import com.learn.facade.SubSystem.SubSystemThree;
import com.learn.facade.SubSystem.SubSystemTwo;

/**
 * Created by hechao on 2017/4/16.
 */
public class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }

    public void methonA() {
        System.out.println("方法组A() ------ ");
        one.methodOne();
        two.methodTwo();
        four.methodFour();
    }

    public void methonB() {
        System.out.println("方法组B() ------ ");
        two.methodTwo();
        three.methodThree();

    }


}
