package com.learn.template;

/**
 * Created by hechao on 2017/3/24.
 */
public abstract class AbstractClass {
    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();

    public void templateMethod(){

        System.out.print("公共部分start\n");
        primitiveOperation1();
        primitiveOperation2();
        System.out.print("公共部分end\n");
    }
}
