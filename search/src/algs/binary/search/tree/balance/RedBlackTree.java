package algs.binary.search.tree.balance;

/**
 * 红黑二叉查找树
 *
 * @param <Key>
 * @param <Value>
 * @author ZhangRui
 * @date 2017年10月27日
 * @time 下午9:31:58
 */
@SuppressWarnings({"javadoc", "unused"})
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    /**
     * 定义结点
     *
     * @author ZhangRui
     * @date 2017年10月27日
     * @time 下午9:31:38
     */
    private class Node {

        Key key;           //键
        Value value;       //相关联的值
        Node left, right;  //左右子树
        int n;             //这课子树中的结点总数
        boolean color;     //由其父节点指向他的链接的颜色

        /**
         * 节点构造器
         *
         * @param key
         * @param value
         * @param n
         * @param color
         */
        Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.n = n;
            this.color = color;
        }
    }

    /**
     * 获取结点总数
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    /**
     * 查找key，找到则更新其值，否则为他创建一个新的结点
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    /**
     * 在以node为根节点的树中查找key，找到则更新其值，否则为他创建一个新的结点
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null) // 标准的插入操作，和父节点用红链接相连
            return new Node(key, value, 1, RED);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 左旋转h的右链接
     *
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node node = h.right;
        h.right = node.left;
        node.left = h;
        node.color = h.color;
        node.n = h.n;
        h.n = size(h.left) + size(h.right) + 1;
        return node;
    }

    /**
     * 右旋转h的左链接
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node node = h.left;
        h.left = node.right;
        node.right = h;
        node.color = h.color;
        node.n = h.n;
        h.n = size(h.left) + size(h.right) + 1;
        return node;
    }

    /**
     * 颜色转换
     *
     * @param h
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 返回以node为根节点的红黑树中的节点个数
     *
     * @param node
     * @return
     */
    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return node.n;
    }

    /**
     * 判断由其父节点指向他的链接的颜色是否是为红色
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

}
