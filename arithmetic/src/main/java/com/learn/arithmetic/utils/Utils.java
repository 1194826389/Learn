package com.learn.arithmetic.utils;

import java.util.List;

public class Utils {

    public Utils() {

    }

    public static void swap(int[] T, int i, int j) {
        int tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }


    public static void printTopKArray(int[] a, int K) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            if (i == K - 1) {
                System.out.print("      ");
            }
        }
        System.out.println("");
    }


    public static int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list) {
            ret[i++] = e;
        }
        return ret;
    }
}
