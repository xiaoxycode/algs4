package algs4.ch5.ch5_2.ex;

import algs4.stdlib.StdOut;

/**
 * 基于三向单词查找树的符号表TST的非递归实现
 *
 * @author xiaoxy
 */
public class Ex_5_2_5_TSTNonRecursive<Value> {

    private Node root;

    private class Node {
        char c;
        Value val;
        Node left, mid, right;
    }


    public Value get(String key) {
        //Ex5.2.7 正确处理空字符串。
        if (key == null || key.length() == 0)
            throw new IllegalArgumentException("argument key to get(String key) is null");
        if (root == null) return null;
        int deep = 0;
        Node x = root;

        while (deep < key.length()) {
            if (x == null) break;
            char c = key.charAt(deep);
            if (c == x.c) {
                deep++;
                if (deep == key.length()) {
                    Value val = x.val;
                    return val;
                }
                x = x.mid;
            } else if (c < x.c) {
                x = x.left;
            } else if (c > x.c) {
                x = x.right;
            }
        }

        return null;
    }


    public void put(String key, Value val) {
        //Ex5.2.7 正确处理空字符串。
        if (key == null || key.length() == 0)
            throw new IllegalArgumentException("argument key to put(String key,Value val) is null");

        int curIndex = 0;
        char c = key.charAt(curIndex);
        if (root == null) {
            root = new Node();
            root.c = c;
        }

        Node curNode = root;
        for (; ; ) {
            if (c < curNode.c) {
                if (curNode.left == null) {
                    Node left = new Node();
                    left.c = c;
                    curNode.left = left;
                }
                curNode = curNode.left;
            } else if (c > curNode.c) {
                if (curNode.right == null) {
                    Node right = new Node();
                    right.c = c;
                    curNode.right = right;
                }
                curNode = curNode.right;
            } else if (++curIndex < key.length()) {
                c = key.charAt(curIndex);
                if (curNode.mid == null) {
                    Node mid = new Node();
                    mid.c = c;
                    curNode.mid = mid;
                }
                curNode = curNode.mid;
            } else {
                curNode.val = val;
                break;
            }
        }
    }


    public static void main(String[] args) {
        Ex_5_2_5_TSTNonRecursive<Integer> ex = new Ex_5_2_5_TSTNonRecursive<>();
        ex.put("daf", 1);
        ex.put("abd", 2);
        ex.put("abe", 3);
        ex.put("abh", 4);
        ex.put("ab", 8);
        ex.put("a", 18);
        ex.put("d", 41);

        StdOut.println(ex.get("abh"));
        StdOut.println(ex.get("ab"));
        StdOut.println(ex.get("a"));
        StdOut.println(ex.get("d"));
    }

}
