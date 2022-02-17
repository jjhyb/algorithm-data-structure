package com.yibo.datastructure.map;

/**
 * @Author: huangyibo
 * @Date: 2022/2/15 21:14
 * @Description: 基于二分搜索树实现映射
 */

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    //二分搜索树节点类
    private class Node<K extends Comparable<K>, V>{

        public K key;

        public V value;

        public Node<K, V> left;

        public Node<K, V> right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
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

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 向二分搜索树添加新的元素(key,value)
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value){
        //向根节点添加元素e
        root = add(root, key, value);
    }

    /**
     * 向以node为根的二分搜索树中插入元素(key,value)，递归算法
     * @param node
     * @param key
     * @param value
     * @return 返回插入新元素的二分搜索树的根
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

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public void set(K key, V value) {
        Node<K, V> node = getNode(root, key);
        if(node == null){
            //不存在直接抛异常
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        //key已存在，则更新
        node.value = value;
    }

    @Override
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
    @Override
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
