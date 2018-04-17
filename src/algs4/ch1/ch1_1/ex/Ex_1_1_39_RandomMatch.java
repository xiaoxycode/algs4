package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;
import algs4.stdlib.StdRandom;

import java.util.Arrays;

/**
 * 编写一个使用BinarySearch 的程序，它从命令行接受一个整型参数T，并会分别针对N=10^3、10^4、10^5 和10^6 将以下实验运行 T 遍：
 * 生成两个大小为N 的随机6 位正整数数组并找出同时存在于两个数组中的整数的数量。
 * 打印一个表格，对于每个N，给出T 次实验中该数量的平均值。
 * Created by John Farrell on 2017/12/3.
 */
public class Ex_1_1_39_RandomMatch {

    public static final int SIZE_1 = 1000;
    public static final int SIZE_2 = 10000;
    public static final int SIZE_3 = 100000;
    public static final int SIZE_4 = 1000000;

    /**
     * 初始化一个大小为size
     *
     * @param size
     * @return
     */

    public static int[] initArray(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = StdRandom.uniform(100000, 999999);
        }
        Arrays.sort(a);
        return a;
    }

    /**
     * source,target的size相等，并且是有序的数组
     *
     * @param source
     * @param target
     * @return
     */
    public static int findSameElement(int[] source, int[] target) {
        int c = 0, tf = 0;
        for (int i = 0; i < source.length; i++) {
            int r = binarySearch(source[i], tf, target);
            if (r == -1) continue;
            else {
                tf = r;
                c++;
            }
        }
        return c;
    }

    public static int binarySearch(int key, int start, int[] a) {
        if (start > a.length - 1) {
            return -1;
        }
        if (a[start] == key) {
            return start;
        }
        int l = start, h = a.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                l = mid + 1;
            } else {
                //a[mid]>key
                h = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] source = initArray(SIZE_4);
        int[] target = initArray(SIZE_4);

        int c1 = findSameElement(source, target);
        StdOut.println("result: T = " + c1);
    }

}
