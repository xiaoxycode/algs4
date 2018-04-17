package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;

/**
 * 编写一个递归的静态方法计算 ln(N!) 的值。
 * Created by John Farrell on 2017/11/24.
 */
public class Ex_1_1_20_Ln {

    public static double lnf(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;
        return lnf(n - 1) + Math.log(n);
    }

    public static void main(String[] args) {
        StdOut.println(lnf(100));
    }

}
