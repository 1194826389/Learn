package com.learn.arithmetic.topk;

public class TopKRandonSelect {


    public TopKRandonSelect(int[] testArr, int K) {
        randonSelect(testArr, 0, testArr.length - 1, K);
    }

    public void randonSelect(int[] A, int p, int r, int k) {
        if (p == r) return;
        int i = partition(A, p, r);
        int temp = i - p + 1; // 数组前半部分元素个数，包括i
        if (temp == k) {      // 如果数组前半部分元素个数就是K,则可以结束。
            return;
        } else if (temp > k) {  // 如果数组前半部分元素个数大于K,则从p到i-1中寻找第K大的元素。
            randonSelect(A, p, i - 1, k);
        } else {                // 如果数组前半部分元素个数小于K,则从i+1到r中寻找第(k-temp)大的元素。
            randonSelect(A, i + 1, r, k - temp);
        }
    }

    int partition(int[] A, int p, int r) {
        int baseNum = A[p];
        int i = p;
        int j = r;
        while (i < j) {
            while (i < j && A[j] <= baseNum) {
                j--;
            }
            A[i] = A[j];
            while (i < j && A[i] >= baseNum) {
                i++;
            }
            A[j] = A[i];
        }
        A[i] = baseNum;
        return i;
    }
}
