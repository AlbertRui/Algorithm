package algs.string.search;

/**
 * 基于单词查找树的符号表
 *
 * @author AlbertRui
 * @date 2018-04-04 21:06
 */
public class TrieST<Value> {

    private static int R = 256;//基数
    private Node root;//单词查找树的根节点

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.val;
    }

    /**
     * 返回以x为根节点的子单词查找树中与key相关联的值
     *
     * @param x
     * @param key
     * @param d
     * @return
     */
    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }

        if (d == key.length()) {
            return x;
        }

        //找到第d个字符所对应的子单词查找树
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.val = value;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d + 1);
        return x;
    }

}
