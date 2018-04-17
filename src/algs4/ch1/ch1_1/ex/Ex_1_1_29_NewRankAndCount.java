package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;

import java.util.Arrays;

/**
 * Created by John Farrell on 2017/11/30.
 */
public class Ex_1_1_29_NewRankAndCount {

    /**
     * 返回数组a中小于key的元素的数量。a已经排序
     *
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= key) {
                break;
            } else {
                n++;
            }
        }
        return n;
    }

    /**
     * 返回数组a中等于key的元素的数量。a已经排序
     *
     * @param key
     * @param a
     * @return
     */
    public static int count(int key, int[] a) {
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < key) {
                continue;
            } else if (a[i] == key) {
                n++;
            } else {
                break;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] l = {0, 0, 1, 2, 3, 4, 3, 2, 4, 2, 5, 2, 7, 8, 5, 4, 3, 2, 9, 10, 12, 22, 12, 11, 10};
        Arrays.sort(l);
        int i = rank(5, l);
        int j = count(5, l);
        StdOut.println(Arrays.toString(l));
        StdOut.printf("rank : %d ,count : %d", i, j);
    }

}
