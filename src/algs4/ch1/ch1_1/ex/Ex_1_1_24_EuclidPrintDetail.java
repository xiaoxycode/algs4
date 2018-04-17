package algs4.ch1.ch1_1.ex;

import algs4.stdlib.CommonTool;
import algs4.stdlib.StdOut;

/**
 * gcd(a,b)=gcd(b,a mod b)
 * Created by John Farrell on 2017/11/25.
 */
public class Ex_1_1_24_EuclidPrintDetail {

    public static int gcd(int p, int q, int deep) {
        if (p < q) {
            p = p ^ q;
            q = p ^ q;
            p = p ^ q;
        }
        StdOut.printf(CommonTool.printNChar("+", deep) + "deep:%s,p:%s,q:%s \n", deep, p, q);
        int n = p % q;
        if (n == 0) {
            return q;
        } else {
            deep = deep + 1;
            return gcd(q, n, deep);
        }
    }

    public static void main(String[] args) {
        StdOut.println(gcd(900, 300, 0));
    }
}
