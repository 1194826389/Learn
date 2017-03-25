package com.learn.template.HM;

/**
 * Created by hechao on 2017/3/24.
 */
public class TemplateClass {

    public void templateMethod(MutableInterface mutableInterface) {
        System.out.print("公共部分\n");
        mutableInterface.mutableMethod();
        System.out.print("公共部分\n");

    }

    public interface MutableInterface {
        void mutableMethod();
    }
}
