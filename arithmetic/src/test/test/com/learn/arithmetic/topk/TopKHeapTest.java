package com.learn.arithmetic.topk;

import com.learn.arithmetic.utils.Utils;
import org.junit.Test;

public class TopKHeapTest {

    @Test
    public void TestTopKHeap() {
        int[] testarr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        int K = 6;
        Utils.printTopKArray(testarr,K);
        new TopKHeap(testarr,K);
        Utils.printTopKArray(testarr,K);

    }
}