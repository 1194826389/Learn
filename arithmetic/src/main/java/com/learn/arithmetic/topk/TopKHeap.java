package com.learn.arithmetic.topk;

import com.learn.arithmetic.utils.Utils;

public class TopKHeap {


    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    static private int heapSize;

    // 时间复杂度：K + (n - K)*lgK 约定于 n*lgK
    public TopKHeap(int[] testArr, int K) {
        int[] a = testArr;
        buildMinHeap(a,K);
        for (int i = K; i < a.length; i++) {
            if (a[i] > a[0]) {
                Utils.swap(a, i, 0);
//                buildMinHeap(a, K);
                maxHeapify(a, 0);
            }
        }
    }

    // 时间复杂度为K
    private void buildMinHeap(int[] A,int size){
        heapSize = size;
        for (int i = heapSize - 1; i >= 0 ; i--) {
            maxHeapify(A,i);
        }
    }

    // 时间复杂度为lgK
    private void maxHeapify(int[] A ,int i) {
        int r = right(i);
        int l = left(i);
        int smallest = i;
        if (l < heapSize && A[l] < A[i]) {
            smallest = l;
        }

        if (r < heapSize && A[r] < A[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            Utils.swap(A, i, smallest);
            maxHeapify(A, smallest);
        }
    }


}
