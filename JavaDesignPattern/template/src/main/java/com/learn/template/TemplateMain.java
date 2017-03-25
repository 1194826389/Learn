package com.learn.template;

import com.learn.template.HM.TemplateClass;

/**
 * Created by hechao on 2017/3/24.
 */
public class TemplateMain {
    public static void main(String arg[]) {
        // 第一种方式
//        AbstractClass c;
//        c = new ConcreteClassA();
//        c.templateMethod();
//
//        c = new ConcreteClassB();
//        c.templateMethod();

        // 第二种方式，其实与第一种方式类似，即在HM中应用到的模板模式，如果只有一部分是易变的话，使用这种方式，还不错，如果是多处易变得话，使用上面的方式比较好
        TemplateClass templateClass = new TemplateClass();
        templateClass.templateMethod(new TemplateClass.MutableInterface() {
            public void mutableMethod() {
                System.out.print("易变动code\n");
            }
        });


    }
}
