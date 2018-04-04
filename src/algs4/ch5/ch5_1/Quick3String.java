package algs4.ch5.ch5_1;

/**
 *
 */
public class Quick3String {

    public static void sort(String[] s) {
        sort(s, 0, s.length - 1, 0);
    }

    /**
     * 对字符数组s的lo~hi段进行排序
     *
     * @param s
     * @param lo
     * @param hi
     * @param d
     */
    private static void sort(String[] s, int lo, int hi, int d) {
        if (lo >= hi) return;
        int lt = lo, gt = hi;
        int v = charAt(s[lo], d);
        int i = lo + 1;

        while (i <= gt) {
            int t = charAt(s[i], d);
            if (t < v) exch(s, lt++, i++);
            else if (t > v) exch(s, i, gt--);
            else i++;
        }

        sort(s, lo, lt - 1, d);
        if (v >= 0) sort(s, lt, gt, d + 1);
        sort(s, gt + 1, hi, d);
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    private static void exch(String[] s, int i, int j) {
        String a = s[i];
        s[i] = s[j];
        s[j] = a;
    }

    public static void main(String[] args) {

    }


}
