package com.learn.arithmetic.topk;

import java.util.ArrayList;
import java.util.List;

public class BitMap {

//        private static final int N = 10000000;
//
//        private int[] a = new int[N/32 + 1];


    private int N;
    private int[] a;


    /**
     *
     * @param sizeBit 一定要比数组中最大的数要大，如果数组中最大的值为100，则sizeBit至少要为100
     */
    BitMap(int sizeBit) {
        N = sizeBit;
        a = new int[N/32 + 1];
    }

    /**
     * 设置所在的bit位为1
     * @param n
     */
    public void addValue(int n){
        //row = n / 32 求十进制数在数组a中的下标
        int row = n >> 5;
        //相当于 n % 32 求十进制数在数组a[i]中的下标
        a[row] |= 1 << (n & 0x1F);
    }

    // 判断所在的bit为是否为1
    public boolean exits(int n){
        int row = n >> 5;
        return (a[row] & ( 1 << (n & 0x1F))) != 1;
    }

    /**
     * 升序
     */
    public List<Integer> getSortedList(int K) {
        List<Integer> sortedList = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            int temp = a[i];
            for(int j=0;j < 32;j++){
                if ((temp & 1) == 1) {
                    sortedList.add(i*32 + j);
                }
                temp >>= 1;
            }
        }
        return sortedList;
    }
}