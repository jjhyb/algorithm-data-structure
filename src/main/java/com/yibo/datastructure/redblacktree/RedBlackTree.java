package com.yibo.datastructure.redblacktree;

/**
 * @Author: huangyibo
 * @Date: 2022/2/27 18:33
 * @Description: 红黑树
 */

public class RedBlackTree<K extends Comparable<K>, V> {

    //红黑树节点颜色常量
    private static final boolean RED = true;

    private static final boolean BLACK = false;

    //红黑树 二分搜索树节点类
    private class Node<K extends Comparable<K>, V>{

        public K key;

        public V value;

        public Node<K, V> left;

        public Node<K, V> right;

        //红黑树节点颜色
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            //默认为红色
            this.color = RED;
        }

        @Override
        public String toString() {
            return key.toString() +" : " + value.toString();
        }
    }

    // 根节点
    private Node<K, V> root;

    // 树容量
    private Integer size;

    public RedBlackTree(){
        root = null;
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int getSize() {
        return size;
    }

    private boolean isRed(Node<K, V> node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }

    /**
     * 向左旋转
     * // 对节点node进行向左旋转操作，返回旋转后新的根节点x
     * //   node                     x
     * //  /   \     左旋转         /  \
     * // T1   x   --------->   node   T3
     * //     / \              /   \
     * //    T2 T3            T1   T2
     * @param node
     * @return
     */
    private Node<K, V> leftRotate(Node<K, V> node){
        Node<K, V> x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;
        //维持红黑树节点的颜色
        x.color = node.color;
        node.color = RED;
        //返回左旋转后的根节点
        return x;
    }

    /**
     * 右旋转
     * // 对节点node进行向右旋转操作，返回旋转后新的根节点x
     * //     node                   x
     * //    /   \     右旋转       /  \
     * //   x    T2   ------->   y   node
     * //  / \                       /  \
     * // y  T1                     T1  T2
     * @param node
     * @return
     */
    private Node<K, V> rightRotate(Node<K, V> node){
        Node<K, V> x = node.left;
        //右旋转
        node.left = x.right;
        x.right = node;
        //维持红黑树节点的颜色
        x.color = node.color;
        node.color = RED;
        //返回右旋转后的根节点
        return x;
    }

    /**
     * 颜色翻转
     * 以node为根包括node的两个左右孩子的颜色翻转
     * @param node
     */
    private void flipColors(Node<K, V> node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 向红黑树添加新的元素(key,value)
     * @param key
     * @param value
     */
    public void add(K key, V value){
        //向根节点添加元素e
        root = add(root, key, value);
        //最终根节点为黑色节点
        root.color = BLACK;
    }

    /**
     * 向以node为根的红黑树中插入元素(key,value)，递归算法
     * @param node
     * @param key
     * @param value
     * @return 返回插入新元素的红黑树的根
     */
    private Node<K, V> add(Node<K, V> node, K key, V value){
        if(node == null){
            size ++;
            return new Node<>(key, value);
        }

        //递归调用，元素添加到node.left
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if(key.compareTo(node.key) > 0){
            //递归调用，元素添加到node.right
            node.right = add(node.right, key, value);
        }else {
            node.value = value;
        }

        //红黑树性质的维护
        //当前node的右孩子节点为红色，左孩子节点不为红色
        if(isRed(node.right) && !isRed(node.left)){
            //左旋转
            leftRotate(node);
        }

        //当前node的左孩子节点为红色，当前node的左孩子的左孩子节点也是红色
        if(isRed(node.left) && isRed(node.left.left)){
            //右旋转
            rightRotate(node);
        }

        //是否需要颜色翻转
        //当前node的左、右孩子节点都为红色
        if(isRed(node.left) && isRed(node.right)){
            //颜色翻转
            flipColors(node);
        }

        //返回当前根节点
        return node;
    }

    /**
     * 根据key从当前以当前node为根节点中寻找value, 不存在返回null
     * @param node
     * @param key
     * @return
     */
    private Node<K, V> getNode(Node<K, V> node, K key){
        //递归终止条件
        if(node == null){
            return null;
        }

        //待寻找key比当前节点key小，递归调用node.left
        if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else if(key.compareTo(node.key) > 0){
            //待寻找key比当前节点key大，递归调用node.right
            return getNode(node.right, key);
        }else {
            //待寻找key和当前节点key相等，直接返回
            return node;
        }
    }


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public void set(K key, V value) {
        Node<K, V> node = getNode(root, key);
        if(node == null){
            //不存在直接抛异常
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        //key已存在，则更新
        node.value = value;
    }


    public V get(K key) {
        Node<K, V> node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node<K, V> minimum(Node<K, V> node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点，
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node<K, V> removeMin(Node<K, V> node){
        if(node.left == null){
            Node<K, V> rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        //递归调用node.left
        node.left = removeMin(node.left);
        return node;
    }

    /**
     *
     * @param e
     */
    /**
     * 从二分搜索树中删除元素键为key的节点, 并返回value, 不存在返回null
     * @param key
     * @return
     */
    public V remove(K key){
        Node<K, V> node = getNode(root, key);
        if(node == null){
            //不存在直接返回null
            return null;
        }
        //存在
        root = remove(root, key);
        return node.value;
    }

    /**
     * 删除以node为根的二分搜索树中键为key的节点，递归递归方式
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param key
     * @return
     */
    private Node<K, V> remove(Node<K, V> node, K key){
        //节点为空，直接返回
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            //待删除元素key小于当前节点的键，向左递归寻找
            node.left = remove(node.left, key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            //待删除元素key大于当前节点的键，向右递归寻找
            node.right = remove(node.right, key);
            return node;
        }else {
            //待删除节点左子树为空
            if(node.left == null){
                Node<K, V> rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            //待删除节点右子树为空
            if(node.right == null){
                Node<K, V> rightNode = node.left;
                node.left = null;
                size --;
                return rightNode;
            }

            //待删除节点左、右子树不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树最小节点
            //用这个节点顶替待删除节点的位置

            //找到比待删除节点大的最小节点，即待删除节点右子树最小节点
            Node<K, V> successor = minimum(node.right);
            //删除比待删除节点大的最小节点，并将返回值给succeer的右孩子
            successor.right = removeMin(node.right);
            //node.left赋值给successor.left
            successor.left = node.left;
            //node节点和二分搜索树脱离关系
            node.left = node.right = null;
            return successor;
        }
    }
}
