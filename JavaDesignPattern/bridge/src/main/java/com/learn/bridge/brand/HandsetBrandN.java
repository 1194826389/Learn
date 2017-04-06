package com.learn.bridge.brand;

/**
 * Created by hechao on 2017/4/6.
 */
public class HandsetBrandN extends HandsetBrand {
    public void run() {
        System.out.println(this.toString());
        handsetSoft.run();
    }

    @Override
    public String toString() {
        return "HandsetBrandN";
    }
}
