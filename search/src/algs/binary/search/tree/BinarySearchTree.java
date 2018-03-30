package algs.binary.search.tree;

/**
 * 基于二叉查找树的符号表
 *
 * @param <Key>
 * @param <Value>
 * @author ZhangRui
 * @date 2017年10月25日
 * @time 下午1:02:48
 */
@SuppressWarnings({"javadoc", "unused"})
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;// 二叉查找树的根节点

    /**
     * 建立结点
     *
     * @author ZhangRui
     * @date 2017年10月25日
     * @time 下午1:02:23
     */
    private class Node {

        private Key key; // 键
        private Value value; // 值
        private Node left, right; // 指向子树的链接
        private int n; // 以该节点为根的子树中的结点总数

        /**
         * 结点构造器
         *
         * @param key
         * @param value
         * @param n
         */
        Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    /**
     * 获取二叉树中结点总数
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    /**
     * 获取结点值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 查找二叉树中是否包含key的节点
     *
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    /**
     * 查找键，找到则更新值，否则创建新元素
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 查找最小键
     */
    public Key min() {
        return min(root).key;
    }

    /**
     * 查找最大键
     *
     * @return
     */
    public Key max() {
        return max(root).key;
    }

    /**
     * 小于等于key的最大键
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null)
            return null;
        return node.key;
    }

    /**
     * 大于等于key的最小键
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    /**
     * 返回排名为k的结点(排名从零开始)
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return select(root, k).key;
    }

    /**
     * 返回给定键的排名
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    /**
     * 删除二叉查找树中的最小结点
     */
    public void delMin() {
        root = delMin(root);
    }

    /**
     * 删除二叉查找树中的最大节点
     */
    public void delMax() {
        root = delMax(root);
    }

    /**
     * 删除结点操作 将指向即将被删除的结点的链接保存为temp 将node指向它的后继结点min（t.right）
     * 将node的右链接指向delMin（t.right） 将node的左链接设为t.left。
     *
     * @param key
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /*============================private method=================================*/

    /**
     * 删除以node为根节点的的二叉查找树中的键key
     *
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            Node temp = node;
            node = min(temp.right);
            node.right = delMin(temp.right);
            node.left = temp.left;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 删除以node为根节点的二叉搜索树中的最小键值所对应的节点
     * 返回删除后的新的二叉树的根节点
     *
     * @param node
     * @return
     */
    private Node delMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = delMin(node.left);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 删除以node为根节点的二叉查找树中的最大节点
     * 返回删除后的新的二叉树的根节点
     *
     * @param node
     * @return
     */
    private Node delMax(Node node) {
        if (node.right == null)
            return node.left;
        node.right = delMax(node.right);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 返回以node为根节点的子树中小于node.key的键的数量（不包过Node.key）
     *
     * @param node
     * @param key
     * @return
     */
    private int rank(Node node, Key key) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(node.left, key);
        else if (cmp > 0)
            return 1 + size(node.left) + rank(node.right, key);
        else
            return size(node.left);
    }

    /**
     * 根据排名查找节点（注意：排名从零开始）
     *
     * @param node
     * @param k
     * @return
     */
    private Node select(Node node, int k) {
        if (node == null)
            return null;
        int t = size(node.left);
        if (t > k)
            return select(node.left, k);
        else if (t < k)
            return select(node.right, k - t - 1);
        else
            return node;
    }

    /**
     * 返回小于等于key的最大键
     * 若该值在node的右子树中，则一定存在
     * 左子树中不一定存在，此时返回null
     *
     * @param node
     * @param key
     * @return
     */
    private Node floor(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        if (cmp < 0)
            return floor(node.left, key);
        Node t = floor(node.right, key);
        if (t != null)
            return t;
        else
            return node;
    }

    /**
     * 在以node为根节点的树中，查找大于等于key的最小键
     *
     * @param node
     * @param key
     * @return
     */
    private Node ceiling(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        if (cmp > 0)
            return ceiling(node.right, key);
        Node temp = ceiling(node.left, key);
        if (temp != null)
            return temp;
        else
            return node;
    }

    /**
     * 返回树种最小键值对应的节点
     *
     * @param node
     * @return
     */
    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    /**
     * 返回树种最大键值对应的节点
     *
     * @param node
     * @return
     */
    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    /**
     * 以该结点为根的子树中的结点总数（包括该结点）
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
     * 在以node为根节点的子树中查找并返回key所对应的值 如果找不到，则返回null
     *
     * @param node
     * @param key
     * @return
     */
    private Value get(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    /**
     * 查找以node为根的节点是否包含键为key的节点
     * 和get方法相类似
     *
     * @param node
     * @param key
     * @return
     */
    private boolean contain(Node node, Key key) {
        //递归到底的情况处理
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    /**
     * 如果key存在于以node为根节点的子树中则更新它的值 否则将以key和value为键值对的新结点插入到该子树中
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 对以node为根节点的树进行前序遍历
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 对以node为根节点的树进行中序遍历
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    /**
     * 对以node为根节点的树进行后序遍历
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

}