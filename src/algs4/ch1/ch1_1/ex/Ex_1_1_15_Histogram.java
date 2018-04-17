package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;
import algs4.stdlib.StdRandom;

/**
 * Created by John Farrell on 2017/11/23.
 */
public class Ex_1_1_15_Histogram {

    public static int[] histogram(int[] a, int M) {
        int[] his = new int[M];
        for (int i = 0; i < a.length; i++) {
            //便利a
            if (a[i] >= 0 && a[i] <= M - 1) {
                his[a[i]]++;
            } else {
                continue;
            }
        }

        return his;
    }

    public static void main(String[] args) {

        int[] a = new int[50];
        int M = 100;
        for (int i = 0; i < 50; i++) {
            a[i] = StdRandom.uniform(100);
        }
        int[] his = Ex_1_1_15_Histogram.histogram(a, M);

        for (int i = 0; i < his.length; i++) {
            StdOut.println("i = " + i + "; his = " + his[i]);
        }

    }

}
