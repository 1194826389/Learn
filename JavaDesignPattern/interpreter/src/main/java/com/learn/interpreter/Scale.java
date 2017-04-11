package com.learn.interpreter;

/**
 * Created by hechao on 2017/4/10.
 */
public class Scale extends Expression {
    public void excute(String key, double value) {
        String scale = "";
        switch ((int)value) {
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
        }
        System.out.println(scale + " ");
    }
}
