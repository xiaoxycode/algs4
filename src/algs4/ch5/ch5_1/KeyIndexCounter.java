package algs4.ch5.ch5_1;

import algs4.stdlib.StdOut;

/**
 * 键索引计数法，适用于小整数键的简单排序方法
 */
public class KeyIndexCounter {

    public void sort(Obj[] s, int R) {
        int N = s.length;
        int[] counter = new int[R + 1];
        Obj[] aux = new Obj[N];

        //统计频率
        for (int i = 0; i < N; i++) {
            counter[s[i].key + 1]++;
        }

        //将频率转换成为索引
        for (int i = 0; i < R; i++) {
            counter[i + 1] += counter[i];
        }

        for (int i = 0; i < N; i++) {
            aux[counter[s[i].key]++] = s[i];
        }

        for (int i = 0; i < N; i++) {
            s[i] = aux[i];
        }

    }

    public class Obj {
        public String value;
        public int key;

        public Obj(String value, int key) {
            this.value = value;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "value='" + value + '\'' +
                    ", key=" + key +
                    '}';
        }
    }

    public static void main(String[] args) {
        KeyIndexCounter k = new KeyIndexCounter();

        Obj[] l = new Obj[10];
        l[0] = k.new Obj("A1", 1);
        l[1] = k.new Obj("b1", 2);
        l[2] = k.new Obj("b2", 2);
        l[3] = k.new Obj("A5", 1);
        l[4] = k.new Obj("e4", 5);
        l[5] = k.new Obj("c1", 3);
        l[6] = k.new Obj("e1", 5);
        l[7] = k.new Obj("e2", 5);
        l[8] = k.new Obj("c2", 3);
        l[9] = k.new Obj("A2", 1);

        k.sort(l, 6);
        for (int i = 0; i < 10; i++) {
            StdOut.println(l[i]);
        }


    }
}
