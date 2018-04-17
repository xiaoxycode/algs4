package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;

/**
 * Created by John Farrell on 2017/11/23.
 */
public class Ex_1_1_14_lg {

    /**
     * 返回不大于log2N的最大整数，不能用math的库。2^x=N
     *
     * @param n
     * @return
     */
    public static int lg(int n) {
        int p = 1;
        int x = -1;
        while (p <= n) {
            p = p * 2;
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        StdOut.println(Ex_1_1_14_lg.lg(100));
    }


}
