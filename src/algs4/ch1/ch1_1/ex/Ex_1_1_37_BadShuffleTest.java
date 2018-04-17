package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;
import algs4.stdlib.StdRandom;

/**
 * Created by John Farrell on 2017/12/3.
 */
public class Ex_1_1_37_BadShuffleTest {


    public static void badShuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = StdRandom.uniform(n - i);     // between 0 and n-1，糟糕的打乱
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }


    public static void initArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }

    public static int[][] shuffleTest(int m, int n) {
        int[] a = new int[m];
        int[][] r = new int[m][m];

        for (int i = 0; i < n; i++) {
            initArray(a);
            badShuffle(a);

            for (int j = 0; j < m; j++) {
                r[a[j]][j] += 1;
            }
        }

        return r;
    }


    public static void main(String[] args) {
        int m = 20, n = 100;
        int[][] a = shuffleTest(m, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                StdOut.print(a[i][j]);
                StdOut.printf("  ");
            }
            StdOut.println();
        }
    }

}
