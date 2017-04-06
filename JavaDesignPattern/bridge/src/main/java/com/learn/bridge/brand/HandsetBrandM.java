package com.learn.bridge.brand;

/**
 * Created by hechao on 2017/4/6.
 */
public class HandsetBrandM extends HandsetBrand {
    @Override
    public void run() {
        System.out.println(this.toString());
        handsetSoft.run();
    }

    @Override
    public String toString() {
        return "HandsetBrandM";
    }
}
