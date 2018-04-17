package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;

/**
 * Created by John Farrell on 2017/12/2.
 */
public class Ex_1_1_30_RelativelyPrime2DArray {


    /**
     * i，j是否互质
     *
     * @param i
     * @param j
     * @return
     */
    public static boolean isRelativelyPrime(int i, int j) {
        //特殊情况
        if (i == j) return false;
        if (i == 1 || j == 1) {
            return true;
        }
        if ((i - j) == -1 || (i - j) == 1) {
            return true;
        }
        //通常情况，使用辗转相除法
        int t = 0;
        while (true) {
            t = i % j;
            if (t == 0) {
                break;
            } else {
                i = j;
                j = t;
            }
        }
        if (j == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean[][] createRelativelyPrime2DArray(int n) {
        boolean[][] a = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    a[i][j] = a[j][i];
                } else {
                    a[i][j] = isRelativelyPrime(i + 1, j + 1);
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        boolean[][] a = createRelativelyPrime2DArray(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                StdOut.print(a[i][j]);
                StdOut.printf("  ");
            }
            StdOut.println();
        }
    }
}
