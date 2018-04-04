package algs4.ch5.ch5_2;


import algs4.stdlib.Queue;

/**
 * R向单词查找树
 * recommit
 */
public class TrieST<Value> {

    private static int R = 256;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    /**
     * 返回R向单词查找树的大小，使用延迟递归实现，但会造成性能上的问题。
     *
     * @return
     */
    public int size1() {
        return size1(root);
    }

    private int size1(Node x) {
        if (x == null) return 0;
        int cnt = 0;
        if (x.val != null) cnt++;//加入自己
        for (int i = 0; i < x.next.length; i++) {
            cnt += size1(x.next[i]);
        }
        return cnt;
    }

    /**
     * 查找key对应的value
     *
     * @param key
     * @return
     */
    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    /**
     * 返回以x为根节点的子单词查找树中与key相关联的结点
     *
     * @param x
     * @param key
     * @param d
     * @return
     */
    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;//说明从根结点到x已经与key匹配
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    /**
     * 插入键值对
     *
     * @param key
     * @param val
     */
    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;//找到，更新与它相关联的值。返回给上一个递归然后放入x.next[c]中。
        }
        char c = key.charAt(d);//找到第d个单词对应的子树。
        x.next[c] = put(x, key, val, d + 1);
        return x;
    }

    /**
     * 遍历所有的键
     *
     * @return
     */
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    /**
     * 返回带有前缀pre的键列表
     *
     * @param pre
     * @return
     */
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    /**
     * 从x结点开始遍历键
     *
     * @param x
     * @param pre
     * @param q
     */
    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.val != null) q.enqueue(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);//good ...
        }
    }

    /**
     * 返回与pat匹配的键，“.”可以匹配任意字符。
     *
     * @param pat
     * @return
     */
    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) q.enqueue(pre);
        if (d == pat.length()) return;

        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) collect(x.next[c], pre + c, pat, q);
        }
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == s.length()) return length;

        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) x.val = null; //找到对应的结点并将值设置为null
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);//递归删除
        }

        if (x.val != null) return x;
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) return x;
        }

        return null;
    }

    public static void main(String[] args) {

    }

}
