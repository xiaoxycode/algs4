package algs4.stdlib;

/**
 * Created by John Farrell on 2017/11/25.
 */
public class CommonTool {
    public static String printNChar(String s, int n) {
        String sn = "";
        while (n >= 0) {
            sn = sn + s;
            n--;
        }
        return sn;
    }


}
