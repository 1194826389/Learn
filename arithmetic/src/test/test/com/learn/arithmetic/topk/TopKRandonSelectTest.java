package com.learn.arithmetic.topk;

import com.learn.arithmetic.utils.Utils;
import org.junit.Test;

public class TopKRandonSelectTest {

    @Test
    public void TestTopKrandonSelect() {
        int testarr[] = {76, 38, 65, 97, 49, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        int K = 6;
        Utils.printTopKArray(testarr,K);
        new TopKRandonSelect(testarr,K);
        Utils.printTopKArray(testarr,K);
    }
}