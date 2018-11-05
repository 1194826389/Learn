package com.learn.arithmetic.sort;


import com.learn.arithmetic.utils.Utils;

public class HeapSort {

    static private int parent(int i) {
        return (i - 1) / 2 ;
    }

    static private int left(int i) {
        return 2 * i + 1;
    }

    static private int right(int i) {
        return 2 * i + 2;
    }

    static int heapSize;

    public static void main(String[] args)  {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        heapSort(a);
        Utils.printArray(a);
    }

//

    //时间复杂度为：n + (n-1)lgn 约等于 nlgn
    static private void heapSort(int[] A) {
        buildMaxHeap(A);
        for (int i = A.length - 1; i >= 1; i--) {
            Utils.swap(A, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(A, 0);
        }
    }

    // 时间复杂度为n
    static private void buildMaxHeap(int[] A) {
        heapSize = A.length;
        for (int i = A.length / 2; i >= 0 ; i--) {
            maxHeapify(A, i);
        }
    }

    // 最大堆堆化，时间复杂度为lgn
    static private void maxHeapify(int[] A,int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        // 第一步：比较i和i的左右孩子大小，即i,r,l，获得三者较大的值
        if (l < heapSize && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < heapSize && A[r] > A[largest]) {
            largest = r;
        }

        // 第二步：如果较大者不是i，则交换i和左右孩子中的较大值，
        // 并继续将下标为largest的结点作为原来的A[i]，于是改结点为根的子树又可可能会违反最大堆的性质，因此继续递归maxHeapify，
        if (largest != i) {
            Utils.swap(A, i, largest);
            maxHeapify(A, largest);
        }
    }
}

