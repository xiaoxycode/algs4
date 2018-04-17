package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;
import algs4.stdlib.StdRandom;

/**
 * Created by John Farrell on 2017/12/2.
 */
public class Ex_1_1_36_ShuffleTest {

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
            StdRandom.shuffle(a);

            for (int j = 0; j < m; j++) {
                r[a[j]][j] += 1;
            }
        }

        return r;
    }


    public static void main(String[] args) {
        int[][] a = shuffleTest(20, 10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                StdOut.print(a[i][j]);
                StdOut.printf("  ");
            }
            StdOut.println();
        }
    }

}
