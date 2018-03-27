package algs4.ch5.ch5_1.ex;

import algs4.stdlib.StdOut;

/**
 * 可以处理变长字符串的低位优先的字符串排序算法
 *
 * @author xiaoxy
 */
public class Ex_5_1_9_LSD {

    // a包括变长的字符串
    public static void sort(String[] a) {
        //首先算出待排序数组中最长的字符串的长度
        int maxLength = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > maxLength) maxLength = a[i].length();
        }

        sort(a, maxLength);
    }

    private static void sort(String[] a, int maxLength) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];


        for (int i = maxLength - 1; i >= 0; i--) {
            int[] counter = new int[R + 1];

            //统计频率，用counter[1]来记录小于当前长度的字符串
            for (int n = 0; n < N; n++) {
                if (i < a[n].length()) {
                    counter[a[n].charAt(i) + 1]++;
                } else counter[1]++;
            }
            //转换为索引
            for (int r = 0; r < R; r++) {
                counter[r + 1] += counter[r];
            }

            //排序
            for (int j = 0; j < N; j++) {
                if (i < a[j].length()) {
                    int c = a[j].charAt(i);
                    int index = counter[c];
                    aux[index] = a[j];
                    counter[c]++;
                } else {
                    aux[counter[0]++] = a[j];
                }
            }
            //回写
            for (int j = 0; j < N; j++) {
                a[j] = aux[j];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"she", "shells", "seashells", "by", "the", "seashore", "the", "shells", "she",
                "sells", "are", "surely", "seashells"};

        String[] b = {"1110", "1120", "1130", "1121", "1141", "1190", "1151", "110", "120"};
        Ex_5_1_9_LSD.sort(a);

        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }

    }
}
