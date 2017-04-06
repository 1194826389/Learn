package com.learn.bridge.brand;

import com.learn.bridge.soft.HandsetSoft;

/**
 * Created by hechao on 2017/4/6.
 */
public abstract class HandsetBrand {
    protected HandsetSoft handsetSoft;

    // 设置手机软件
    public void setHandsetSoft(HandsetSoft handsetSoft) {
        this.handsetSoft = handsetSoft;
    }

    public abstract void run();



}
