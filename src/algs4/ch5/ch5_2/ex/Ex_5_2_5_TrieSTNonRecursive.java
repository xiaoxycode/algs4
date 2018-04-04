package algs4.ch5.ch5_2.ex;

import algs4.stdlib.Queue;
import algs4.stdlib.Stack;
import algs4.stdlib.StdOut;

/**
 * TrieST的非递归实现
 * recommit
 *
 * @author xiaoxy
 */
public class Ex_5_2_5_TrieSTNonRecursive<Value> {

    private static int R = 256;
    private int N = 0;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Value get(String key) {
        if (key == null) throw new IllegalArgumentException("calls get(String key) with a null key");
        Node x = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (x != null) {
                x = x.next[c];
            } else break;
        }

        if (x != null) return (Value) x.val;
        else return null;
    }

    /**
     * 把一个key-value对加入符号表中。
     * 如果key存在，更新原来key的值
     *
     * @param key
     * @param value
     */
    public void put(String key, Value value) {
        if (key == null) throw new IllegalArgumentException("calls put(String key, Value value) with a null key");
        if (root == null) root = new Node();
        Node x = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (x.next[c] == null) x.next[c] = new Node();
            if (i == key.length() - 1) {
                if (x.next[c].val == null) N++;
                x.next[c].val = value;
            } else x = x.next[c];
        }
    }

    /**
     * 遍历获取所有键
     *
     * @return
     */
    public Iterable<String> keys() {
        if (root == null) return null;
        //定义一个内部类记录每个结点以及根结点到这个结点的路径
        class NodePath {
            Node node;
            String path;

            public NodePath(Node node, String path) {
                this.node = node;
                this.path = path;
            }
        }

        Queue<String> q = new Queue<>();
        Stack<NodePath> stk = new Stack<>();
        NodePath rootPath = new NodePath(root, "");
        stk.push(rootPath);

        while (!stk.isEmpty()) {
            NodePath xPath = stk.pop();
            Node x = xPath.node;
            String path = xPath.path;
            for (int c = 255; c >= 0; c--) {
                //从右到左
                if (x.next[c] != null) {
                    Node n = x.next[c];
                    String nPath = path + (char) c;
                    NodePath np = new NodePath(n, nPath);
                    stk.push(np);
                }
            }
            if (x.val != null) q.enqueue(path);
        }

        return q;
    }

    /**
     * 返回与pat匹配的键，“.”可以匹配任意字符。
     * “.”的acsii码是46
     *
     * @param pat
     * @return
     */
    public Iterable<String> keysThatMatch(String pat) {
        if (pat == null) throw new IllegalArgumentException("calls keysThatMatch(String pat) with a null pat");
        if (root == null) return null;
        class NodePath {
            Node node;
            String path;

            public NodePath(Node node, String path) {
                this.node = node;
                this.path = path;
            }
        }

        Queue<String> q = new Queue<>();
        Queue<NodePath> npq = new Queue<>();
        NodePath nodePath = new NodePath(root, "");
        npq.enqueue(nodePath);
//        Node x=root;

        for (int i = 0; i < pat.length(); i++) {
            char c = pat.charAt(i);
            if (c != 46) {
                //非"."的字符
                Queue<NodePath> tmpQ = new Queue<>();

                while (!npq.isEmpty()) {
                    NodePath np = npq.dequeue();
                    Node x = np.node;
                    if (x.next[c] == null) continue;
                    else {
                        Node n = x.next[c];
                        String path = np.path + c;
                        NodePath p = new NodePath(n, path);
                        tmpQ.enqueue(p);
                        if (p.node.val != null && i == pat.length() - 1) q.enqueue(p.path);
                    }
                }
                while (!tmpQ.isEmpty()) {
                    npq.enqueue(tmpQ.dequeue());
                }
            } else {
                //遇到.的字符，把前面的路径取出，然后拼接上现在结点x的路径，再加入队列
                Queue<NodePath> tmpQ = new Queue<>();
                while (!npq.isEmpty()) {
                    NodePath np = npq.dequeue();
                    Node x = np.node;
                    for (int j = 0; j < R; j++) {
                        if (x.next[j] != null) {
                            Node n = x.next[j];
                            String path = np.path + (char) j;
                            NodePath p = new NodePath(n, path);
                            tmpQ.enqueue(p);
                            if (p.node.val != null && i == pat.length() - 1) q.enqueue(p.path);
                        }
                    }
                }
                while (!tmpQ.isEmpty()) {
                    npq.enqueue(tmpQ.dequeue());
                }
            }
        }

        return q;
    }

    /**
     * 删除键key
     *
     * @param key
     */
    public void delete(String key) {

    }

    public static void main(String[] args) {

        Ex_5_2_5_TrieSTNonRecursive<Integer> ex = new Ex_5_2_5_TrieSTNonRecursive<>();

        ex.put("ab", 1);
        ex.put("abe", 13);
        ex.put("ac", 12);
        ex.put("ace", 2);
        ex.put("acf", 3);
        ex.put("ack", 4);
        ex.put("aceh", 5);
        ex.put("aceg", 6);
        ex.put("acfg", 7);
        ex.put("ackg", 8);
        ex.put("acegx", 9);
        ex.put("acegy", 10);
        ex.put("acegz", 11);
        ex.put("ackgh", 12);
        ex.put("ackgi", 13);
        ex.put("ackgj", 14);
        ex.put("acegzp", 11);
        ex.put("ackghp", 12);
        ex.put("ackgiy", 13);
        ex.put("ackgjq", 14);

        StdOut.println("------------------ac.g------------------");
        for (String p : ex.keysThatMatch("ac.g")) {
            StdOut.println(p);
        }

        StdOut.println("------------------ac.g.------------------");
        for (String p : ex.keysThatMatch("ac.g.")) {
            StdOut.println(p);
        }

        StdOut.println("------------------ac.g.p------------------");
        for (String p : ex.keysThatMatch("ac.g.p")) {
            StdOut.println(p);
        }

        StdOut.println("------------------a.------------------");
        for (String p : ex.keysThatMatch("a.")) {
            StdOut.println(p);
        }


//        StdOut.println();
//        for (String p : ex.keys()) {
//            StdOut.println(p);
//        }
    }

}
