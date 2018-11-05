package com.learn.arithmetic.topk;

import com.learn.arithmetic.utils.Utils;

import java.util.Collections;
import java.util.List;

public class TopKBitmap {

    public int[] c ;

    public TopKBitmap(int[] testArr, int K) {
        int a[] = testArr;
        // 4G = 4*1024*1024*1024 * 8 bit
        BitMap bitMap = new BitMap(100);
        for (int i = 0; i < a.length; i++) {
            bitMap.addValue(a[i]);
        }
        List newA = bitMap.getSortedList(K);
        Collections.reverse(newA);
        c = Utils.toIntArray(newA);
    }
}
