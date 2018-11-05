package com.learn.arithmetic.isprime;

/**
 * Created by hechao on 2017/6/9.
 */
public class isprime {
    public static void main(String[] args) {
        sieve(10000);
    }

    // 寻找素数
    static void sieve(int n)
    {
        boolean[] a = new boolean[n+1];
        for (int i = 2; i <= n; i++)  a[i] = true;
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (a[i])
                for (int j = i; j*i <= n; j++) a[j * i] = false;
        }


        int c = 0;
        for (int i = 0; i <= n; i++)
        {

            if (a[i]) {
                System.out.printf(i + "\n");
                c++;
            }
        }
        System.out.printf("素数个数 =" + c);
    }
}
