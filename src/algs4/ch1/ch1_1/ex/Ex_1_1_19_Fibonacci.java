package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;

/**
 * 计算第N个Fibonacci数
 * Created by John Farrell on 2017/11/23.
 */
public class Ex_1_1_19_Fibonacci {

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long quickF(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        long f = 0, g = 1;
        for (int i = 2; i <= N; i++) {
            f = f + g;
            g = f - g;//g等于上一个f
        }
        return f;
    }

    public static void main(String[] args) {
        for (int N1 = 0; N1 < 100; N1++) {
            StdOut.println(N1 + " -- " + Ex_1_1_19_Fibonacci.quickF(N1));
        }


    }
}
