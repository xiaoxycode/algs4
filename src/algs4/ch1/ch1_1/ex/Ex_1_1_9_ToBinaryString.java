package algs4.ch1.ch1_1.ex;

import algs4.stdlib.StdOut;

/**
 * Created by John Farrell on 2017/11/22.
 */
public class Ex_1_1_9_ToBinaryString {

    public static String toBinaryString(int n) {
        String s = "";
        for (int i = n; i > 0; i = i / 2) {
            s = (i % 2) + s;
        }

        return s;
    }

    public static void main(String[] args) {
        StdOut.println(Ex_1_1_9_ToBinaryString.toBinaryString(9899));
    }
}
