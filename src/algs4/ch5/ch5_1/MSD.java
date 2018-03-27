package algs4.ch5.ch5_1;

import algs4.stdlib.StdOut;

/**
 * 高位优先的字符串排序
 *
 * @author xiaoxy
 */
public class MSD {
    private static final int BITS_PER_BYTE = 8;
    private static final int BITS_PER_INT = 32;   // each Java int is 32 bits
    private static final int R = 256;   // extended ASCII alphabet size
    private static final int CUTOFF = 1;   // cutoff to insertion sort


    public static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, 0, a.length - 1, 0, aux);
    }


    // do not instantiate
    private MSD() {
    }

    // sort from a[lo] to a[hi], starting at the dth character
    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {

        if (hi <= lo + CUTOFF) {
            //如果是小字符串数组，直接使用插入排序。
            insertionSort(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];
        //根据字符串数组a中的每个字符串的第d位，计算频率
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        //把频率转换成索引
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        //根据索引把数据分类,count[charAt(a[i],d)+1] 对应索引的count[r+1]
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);
        }
    }

    /**
     * 插入排序，从第d个字符为键。
     * 而且短的字符串大于所有字符串。
     *
     * @param a
     * @param lo
     * @param hi
     * @param d
     */
    private static void insertionSort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        int ans = s.charAt(d);
        return ans;  //返回ascii
    }

    private static void exch(String[] s, int i, int j) {
        String a = s[i];
        s[i] = s[j];
        s[j] = a;
    }

    /**
     * 1、从第d个字符开始比较两个字符串的大小。
     * 2、短的字符串大于长的字符串。
     *
     * @param v
     * @param w
     * @param d
     * @return
     */
    private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }

    public static void main(String[] args) {
        String[] a = {"she", "shells", "seashells", "by", "the", "seashore", "the", "shells", "she",
                "sells", "are", "surely", "seashells"};

        MSD.sort(a);

        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
