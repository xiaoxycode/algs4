package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by John Farrell on 2017/11/25.
 */
public class Ex_1_1_22_RankWithDeep {

    public static int rank(int key, int[] a) {
        return rankWithDeep(key, a, 0, a.length - 1, 0);
    }

    public static int rankWithDeep(int key, int[] a, int lo, int hi, int deep) {
        if (lo > hi) return -1;
        deep = deep + 1;
        String sn = printNChar("+", deep);
        StdOut.printf(sn + "deep:%s,lo:%s,hi:%s\n", deep, lo, hi);

        int mid = lo + (hi - lo) / 2;
        if (a[mid] > key) {
            hi = mid - 1;
            return rankWithDeep(key, a, lo, hi, deep);
        } else if (a[mid] < key) {
            lo = mid + 1;
            return rankWithDeep(key, a, lo, hi, deep);
        } else {
            return mid;
        }
    }

    public static String printNChar(String s, int n) {
        String sn = "";
        while (n >= 0) {
            sn = sn + s;
            n--;
        }
        return sn;
    }

    public static void main(String[] args) {
        int[] l = new int[50];
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            l[i] = r.nextInt(200);
        }
        Arrays.sort(l);
        StdOut.println(rank(150, l));
    }
}
