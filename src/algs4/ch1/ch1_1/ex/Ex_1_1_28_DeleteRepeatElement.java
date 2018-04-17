package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;

import java.util.Arrays;

/**
 * Created by John Farrell on 2017/11/29.
 */
public class Ex_1_1_28_DeleteRepeatElement {

    /**
     * 删除a中所有的重复元素，a已经排序
     *
     * @param a
     * @return
     */
    public static int[] deleteRepeat(int[] a) {
        int tmpI = 0;
        if (a.length == 1) return a;

        for (int i = 0; i < a.length; i++) {
            //遍历a ;
            if (a[tmpI] == a[i]) {
                continue;
            } else {
                a[tmpI + 1] = a[i];
                tmpI++;
            }
        }

        return Arrays.copyOfRange(a, 0, tmpI + 1);
    }

    public static void main(String[] args) {
        int[] l = {0, 1, 2, 3, 4};
        Arrays.sort(l);
        StdOut.println(Arrays.toString(l));

        StdOut.println("deleteRepeat result: " + Arrays.toString(deleteRepeat(l)));
    }
}
