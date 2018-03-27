package algs4.ch5.ch5_1;

import algs4.stdlib.StdOut;
import algs4.stdlib.StdRandom;

/**
 * 低位优先的字符串排序
 *
 * @author xiaoxy
 */
public class LSD {

    //通过前W个字符将a排序
    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int i = w - 1; i >= 0; i--) {
            int[] counter = new int[R + 1];

            //统计频率
            for (int j = 0; j < N; j++) {
                counter[a[j].charAt(i) + 1]++;
            }

            //把频率转换成索引
            for (int j = 0; j < R; j++) {
                counter[j + 1] += counter[j];
            }

            //排序
            for (int j = 0; j < N; j++) {
                aux[counter[a[j].charAt(i)]++] = a[j];
            }

            //回写。
            for (int j = 0; j < N; j++) {
                a[j] = aux[j];
            }
        }
    }


    public static void main(String[] args) {
        int N = 20, w = 8;
        String[] s = new String[N];
        for (int i = 0; i < N; i++) {
            s[i] = StdRandom.createRandomString(w);
        }

        LSD.sort(s, w);

        for (int i = 0; i < N; i++) {
            StdOut.println(s[i]);
        }
    }
}
