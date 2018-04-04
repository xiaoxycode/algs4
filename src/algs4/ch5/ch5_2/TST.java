package algs4.ch5.ch5_2;

/**
 * 基于三向单词查找树的符号表
 * recommit
 */
public class TST<Value> {

    private Node root;

    private class Node {
        char c;
        Value val;
        Node left, mid, right;
    }

    public Value get(String key) {
        return get(root, key, 0).val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);

        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid, key, d + 1);
        else return x;
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            //创建一个新节点然后加入到查找树中
            x = new Node();
            x.c = c;
        }

        if (c < x.c) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);
        else x.val = val;
        return x;
    }


}
