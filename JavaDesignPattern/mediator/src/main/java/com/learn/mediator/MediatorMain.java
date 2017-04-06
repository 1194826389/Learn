package com.learn.mediator;

/**
 * Created by hechao on 2017/4/6.
 */
public class MediatorMain {
    public static void main(String arg[]) {
        ConcreteMediator m = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        m.setColleague1(c1);
        m.setColleague2(c2);

        c1.send("吃过放了吗？");
        c2.send("还没呢，你打算请客吗？");


    }
}
