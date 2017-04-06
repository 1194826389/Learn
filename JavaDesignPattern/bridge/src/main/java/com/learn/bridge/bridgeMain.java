package com.learn.bridge;

import com.learn.bridge.brand.HandsetBrand;
import com.learn.bridge.brand.HandsetBrandM;
import com.learn.bridge.brand.HandsetBrandN;
import com.learn.bridge.soft.HandsetAddressList;
import com.learn.bridge.soft.HandsetGame;

/**
 * Created by hechao on 2017/4/6.
 */
public class bridgeMain {
    public static void main(String arg[]) {


        // 请求操作
        HandsetBrand brand;
        brand = new HandsetBrandN();

        brand.setHandsetSoft(new HandsetGame());
        brand.run();

        brand.setHandsetSoft(new HandsetAddressList());
        brand.run();

        brand = new HandsetBrandM();

        brand.setHandsetSoft(new HandsetGame());
        brand.run();

        brand.setHandsetSoft(new HandsetAddressList());
        brand.run();


    }
}
