package com.yibo.datastructure.redblacktree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: huangyibo
 * @Date: 2022/3/2 0:01
 * @Description: 红黑树
 */

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = false;

    private static final boolean BLACK = true;

    //节点类型
    static class Node<K extends Comparable<K>, V> {

        Node<K, V> parent;  // 父结点

        Node<K, V> left;    // 左孩子

        Node<K, V> right;   // 右孩子

        boolean color;      // 颜色

        K key;

        V value;

        public Node(K key, V value, Node<K, V> parent) {
            this.parent = parent;
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return (this.color==RED?"[R]":"[B]") +key + "=" + value;
        }
    }


    // 根节点
    private Node<K, V> root;


    // 树容量
    private Integer size;


    public RBTree(){
        root = null;
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int getSize() {
        return size;
    }


    /**
     * 前序遍历"红黑树"
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历"红黑树"
     * @param node
     */
    private void preOrder(Node<K, V> node) {
        if(node != null) {
            System.out.print(node.key+":"+node.value+" ,");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    /**
     * 中序遍历"红黑树"
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历"红黑树"
     * @param node
     */
    private void inOrder(Node<K, V> node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.key+":"+node.value+" ,");
            inOrder(node.right);
        }
    }


    /**
     * 后序遍历"红黑树"
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历"红黑树"
     * @param node
     */
    private void postOrder(Node<K, V> node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key+":"+node.value+" ,");
        }
    }


    /**
     * 红黑树的层序遍历
     */
    public void layerErgodic(){
        layerErgodic(root);
    }

    /**
     * 红黑树的层序遍历
     * 层序遍历, 从左到右一层一层遍历, 借助队列实现
     * @param node
     */
    public void layerErgodic(Node<K, V> node){
        // LinkedList实现了Queue接口
        Queue<Node<K, V>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<K, V> cur = queue.remove();
            System.out.print(node.key+":"+node.value+" ,");
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }


    /**
     * 查找最小结点的key
     * @return
     */
    public K minimum() {
        Node<K, V> p = minimum(root);
        if (p != null){
            return p.key;
        }
        return null;
    }

    /**
     * 查找最小结点：返回tree为根结点的红黑树的最小结点。
     * @param tree
     * @return
     */
    private Node<K, V> minimum(Node<K, V> tree) {
        if (tree == null) {
            return null;
        }

        while(tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }


    /**
     * 查找最大结点的key
     * @return
     */
    public K maximum() {
        Node<K, V> p = maximum(root);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    /**
     * 查找最大结点：返回tree为根结点的红黑树的最大结点。
     * @param tree
     * @return
     */
    private Node<K, V> maximum(Node<K, V> tree) {
        if (tree == null) {
            return null;
        }

        while(tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }


    /**
     * 获取节点node的颜色
     * @param node
     * @return
     */
    private boolean colorOf(Node<K, V> node) {
        return node != null ? node.color : BLACK;
    }


    /**
     * 获取节点node的父节点
     * @param node
     * @return
     */
    private Node<K, V> parentOf(Node<K, V> node) {
        return node != null ? node.parent : null;
    }


    /**
     * 获取节点node的左子节点
     * @param node
     * @return
     */
    private Node<K, V> leftOf(Node<K, V> node) {
        return node != null ? node.left : null;
    }


    /**
     * 获取节点node的右子节点
     * @param node
     * @return
     */
    private Node<K, V> rightOf(Node<K, V> node) {
        return node != null ? node.right : null;
    }


    /**
     * 设置节点node的颜色
     * @param node
     * @param color
     */
    private void setColor(Node<K, V> node, boolean color) {
        if (node != null){
            node.color = color;
        }
    }


    /**
     * 向左旋转
     * // 对节点node进行向左旋转操作
     * //   node                     x
     * //  /   \     左旋转         /  \
     * // T1   x   --------->   node   T3
     * //     / \              /   \
     * //    T2 T3            T1   T2
     * 左旋的时候：
     *      node-T1和 x-T3 不变
     *      node-x变为 node-T2
     * 判断node节点是否有父节点
     *      如果没有：
     *          x为root节点
     *      如果有：
     *          x.parent = node.parent
     *      还要设置 x为 node.parent的左右子节点
     *
     * 最后设置
     *          node-x 为 x-node
     * @param node
     * @return
     */
    private void leftRotate(Node<K, V> node){
        if(node != null){
            Node<K, V> x = node.right;
            // 将 x的左孩子 设为 node的右孩子
            node.right = x.left;
            // 如果 x 的左孩子非空，将 node 设为 x的左孩子的父亲
            if(x.left != null){
                x.left.parent = node;
            }
            //判断node是否有父节点
            x.parent = node.parent;
            if(node.parent == null){
                // 如果 node的父亲 是空节点，则将x设为根节点
                this.root = x;
            }else if(node.parent.left == node){
                // 如果 node是它父节点的左孩子，则将x设为 node 的父节点的左孩子
                node.parent.left = x;
            }else {
                // 如果 node是它父节点的右孩子，则将x设为 node的父节点的右孩子
                node.parent.right = x;
            }

            // 将 node 设为 x的左孩子
            x.left = node;
            // 将 node的父节点 设为 x
            node.parent = x;
        }
    }


    /**
     * 向右旋转
     * // 对节点node进行向右旋转操作
     * //     node                   x
     * //    /   \     右旋转       /  \
     * //   x    T3   ------->   T1   node
     * //  / \                       /  \
     * // T1  T2                    T2  T3
     * 右旋的时候：
     *      node-T3 和 x-T1 不变
     *      x-T2变为 node-T2
     * 判断node节点是否有父节点
     *      如果没有：
     *          x为root节点
     *      如果有：
     *          x.parent = node.parent
     *      还要设置 x为 node.parent的左右子节点
     *
     * 最后设置
     *          node-x 为 x-node
     * @param node
     * @return
     */
    private void rightRotate(Node<K, V> node){
        if(node != null){
            Node<K, V> x = node.left;
            // 将 x的右孩子 设为 node的左孩子
            node.left = x.right;
            // 如果 x 的右孩子非空，将 node 设为 x的右孩子的父亲
            if(x.right != null){
                x.right.parent = node;
            }
            //判断node是否有父节点
            x.parent = node.parent;
            if(node.parent == null){
                // 如果 node的父亲 是空节点，则将x设为根节点
                this.root = x;
            }else if(node.parent.left == node){
                // 如果 node是它父节点的左孩子，则将x设为 p 的父节点的左孩子
                node.parent.left = x;
            }else {
                // 如果 node是它父节点的右孩子，则将x设为 node的父节点的左孩子
                node.parent.right = x;
            }

            // 将 node 设为 x的右孩子
            x.right = node;
            // 将 node的父节点 设为 x
            node.parent = x;
        }
    }


    /**
     * 新增节点(key,value)
     * 红黑树节点的新增
     *      1、普通的二叉树的插入
     *          先查询到插入的位置
     *          将K V 封装为node对象，插入到tree中
     *      2、红黑树的平衡(调整 旋转+变色)
     * @param key
     * @param value
     */
    public void put(K key, V value){
        if(key == null){
            throw new NullPointerException();
        }

        Node<K, V> temp = this.root;
        if(temp == null){
            //说明红黑树是空的，插入的节点就是root节点
            this.root = new Node<>(key, value, null);
            setColor(this.root, BLACK);
            size = 1;
            return;
        }
        //查找插入的位置
        int cmp = 0;
        //记录寻找节点的父节点
        Node<K, V> parent = null;
        while (temp != null){
            //如果红黑树中不存在key, 则key添加到parent节点下面
            parent = temp;
            cmp = key.compareTo(temp.key);
            if(cmp < 0){
                temp = temp.left;
            }else if (cmp > 0){
                temp = temp.right;
            }else {
                //红黑树中存在key 直接替换value
                temp.value = value;
                return;
            }
        }
        //循环完成，如果红黑树中不存在key, 则key添加到parent节点下面
        Node<K, V> node = new Node<>(key, value, parent);
        if(cmp < 0){
            //如果key比 parent节点的key小，则插入到parent节点的左侧
            parent.left = node;
        }else {
            //如果key比 parent节点的key大，则插入到parent节点的右侧
            parent.right = node;
        }

        //做平衡处理，旋转+变色
        fixAfterInsertion(node);
        size++;
    }


    /**
     * 红黑树平衡的调整处理 旋转+变色
     * 1、2-3-4树, 2节点新增一个元素, 直接合并为3节点
     *      红黑树：新增一个红色节点, 这个红色节点会添加在黑色节点下，不需要调整
     * 2、2-3-4树, 3节点新增一个元素, 合并为一个4节点
     *      红黑树：就会有6种情况, 2种(左中右)的不需要调整
     *              根左左, 根右右 只旋转一次
     *              根左右, 根右左旋转2次
     * 3、2-3-4树, 4节点新增一个元素, 4节点中间元素升级为父节点，新增元素跟剩下节点合并
     *      红黑树：新增节点是红色+爷爷节点是黑色，父节点和叔叔节点是红色
     *              调整为：爷爷节点变为红色，父节点和叔叔节点变为黑色，如果爷爷节点为root节点，则调整为黑色
     * @param node
     */
    private void fixAfterInsertion(Node<K, V> node){
        //插入的节点都为红色节点
        setColor(node, RED);
        while (node != null && node != root && parentOf(node).color == RED){
            //node的父节点是node的爷爷节点的左子节点, 4种需要处理的情况
            if(parentOf(node) == parentOf(parentOf(node)).left){
                //满足条件的四种情况, 根据是否有叔叔节点，又一分为2处理
                //获取当前节点的叔叔节点
                Node<K, V> y = rightOf(parentOf(parentOf(node)));
                if(colorOf(y) == RED){
                    //说明叔叔节点存在，满足条件3的情况
                    //爷爷节点变为红色，父节点和叔叔节点变为黑色
                    setColor(parentOf(node), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    // 如果插入节点的爷爷节点为红色
                    // 将插入节点变为爷爷节点, 循环处理
                    node = parentOf(parentOf(node));
                }else {
                    //叔叔节点不存在,满足条件2
                    if(node == rightOf(node)){
                        //插入节点是父节点的右侧节点，则先根据父节点做一次左旋操作
                        node = parentOf(node);
                        //左旋操作
                        leftRotate(node);
                    }
                    //父节点变为黑色节点
                    setColor(parentOf(node), BLACK);
                    //爷爷节点变为红色节点
                    setColor(parentOf(parentOf(node)), RED);
                    //根据爷爷节点做一次右旋操作
                    rightRotate(parentOf(parentOf(node)));
                }
            }else {
                //node的父节点是node的爷爷节点的右子节点, 4种需要处理的情况,和上面刚好相反
                //满足条件的四种情况, 根据是否有叔叔节点，又一分为2处理
                //获取当前节点的叔叔节点
                Node<K, V> y = leftOf(parentOf(parentOf(node)));
                if(colorOf(y) == RED){
                    //说明叔叔节点存在，满足条件3的情况
                    //爷爷节点变为红色，父节点和叔叔节点变为黑色
                    setColor(parentOf(node), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    // 如果插入节点的爷爷节点为红色
                    // 将插入节点变为爷爷节点, 循环处理
                    node = parentOf(parentOf(node));
                }else {
                    //叔叔节点不存在,满足条件2
                    if (node == leftOf(node)) {
                        //插入节点是父节点的左侧节点，则先根据父节点做一次右旋操作
                        node = parentOf(node);
                        //右旋操作
                        rightRotate(node);
                    }
                    //父节点变为黑色节点
                    setColor(parentOf(node), BLACK);
                    //爷爷节点变为红色节点
                    setColor(parentOf(parentOf(node)), RED);
                    //根据爷爷节点做一次左旋操作
                    leftRotate(parentOf(parentOf(node)));
                }
            }
        }
        //根节点都为黑色节点
        setColor(root, BLACK);
    }


    /**
     * 查找node的前驱节点
     * @param node
     * @return
     */
    private Node<K, V> predecessor(Node<K, V> node){
        if(node == null){
            return null;
        }
        //node节点的左子节点不为空
        if(node.left != null){
            Node<K, V> temp = node.left;
            //temp的右子节点不为空，一直循环
            while (temp.right != null){
                temp = temp.right;
            }
            return temp;
        }else {
            //如果node为叶子节点，那么找比node小的最大节点
            //这种情况在删除中是不存在的，因为删除叶子节点，直接删除即可
            //但是在寻找前驱或者后继节点还是存在的
            Node<K, V> p = node.parent;
            Node<K, V> temp = node;
            while (p != null && temp == p.left){
                temp = p;
                p = p.parent;
            }
            return p;
        }
    }


    /**
     * 查找node的后继节点
     * @param node
     * @return
     */
    private Node<K, V> successor(Node<K, V> node){
        if(node == null){
            return null;
        }
        //node节点的右子节点不为空
        if(node.right != null){
            Node<K, V> temp = node.right;
            //temp的左子节点不为空，一直循环
            while (temp.left != null){
                temp = temp.left;
            }
            return temp;
        }else {
            //如果node为叶子节点，那么找比node大的最小节点
            //这种情况在删除中是不存在的，因为删除叶子节点，直接删除即可
            //但是在寻找前驱或者后继节点还是存在的
            Node<K, V> p = node.parent;
            Node<K, V> temp = node;
            while (p != null && temp == p.right){
                temp = p;
                p = p.parent;
            }
            return p;
        }
    }


    /**
     * 根据key获取对应的节点
     * @param key
     * @return
     */
    private Node<K, V> getNode(K key){
        if(key == null){
            throw new NullPointerException();
        }

        Node<K, V> node = this.root;
        while (node != null){
            int cmp = key.compareTo(node.key);
            if(cmp < 0){
                node = node.left;
            }else if(cmp > 0){
                node = node.right;
            }else {
                return node;
            }
        }
        return null;
    }


    /**
     * 获取键为key的节点的值，不存在返回空
     * @param key
     * @return
     */
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return (node == null ? null : node.value);
    }


    /**
     * 删除键为key的节点，并返回被删除的结点的值
     * @param key
     * @return
     */
    public V remove(K key){
        //先根据key找到对应的节点
        Node<K, V> node = getNode(key);
        if(node == null){
            //key不存在
            return null;
        }
        //把删除节点原来的值保存下来
        V oldValue = node.value;
        //删除节点的方法
        deleteNode(node);
        size--;
        return oldValue;
    }


    /**
     * 删除结点node
     * 3种情况：
     *      1、删除叶子节点，直接删除
     *      2、删除节点有一个子节点，用子节点来替代
     *      3、删除的节点有2个子节点，那么此时需要获取被删除节点的前驱或者后继节点来替代
     *          可以转换为1、2的情况
     * @param node
     */
    private void deleteNode(Node<K, V> node){
        //情况3：被删除节点有左、右子节点，转换为1、2的情况处理
        if(leftOf(node) != null && rightOf(node) != null){
            //找到颜删除节点的后继节点
            Node<K, V> successor = successor(node);
            //然后用后继节点的值, 覆盖掉要删除节点的信息
            node.key = successor.key;
            node.value = successor.value;
            //然后要删除的节点就变成了后继节点
            node = successor;
        }

        //获取要替换的节点
        Node<K, V> replacement = node.left != null ? node.left : node.right;
        if(replacement != null){
            //情况2：删除有一个子节点的情况
            //将删除节点的父节点设置为替换节点的父节点
            replacement.parent = node.parent;
            if(node.parent == null){
                //删除节点的父节点为空，则替换节点设置为根节点
                root = replacement;
            }else if(node == leftOf(parentOf(node))){
                //删除节点为其父节点的左子节点
                parentOf(node).left = replacement;
            }else {
                //删除节点为其父节点的右子节点
                parentOf(node).right = replacement;
            }

            //将node节点的左、右孩子和父指针都指向null, 等待gc
            node.left = node.right = node.parent = null;

            //替换完成后需要调整红黑树的平衡
            if(node.color == BLACK){
                //只有删除节点为黑节点才需要做平衡操作
                fixAfterDeletion(replacement);
            }
        }else if(node.parent == null){
            //要删除的是root节点
            root = null;
        }else {
            //情况1：删除的是叶子结点, 直接删除
            //先调整
            if(node.color == BLACK){
                //只有删除节点为黑节点才需要做平衡操作
                fixAfterDeletion(node);
            }
            //在删除
            if(node.parent != null){
                if(node == leftOf(parentOf(node))){
                    parentOf(node).left = null;
                }else {
                    parentOf(node).right = null;
                }
                node = null;
            }
        }
    }


    /**
     * 删除节点后的调整处理
     * 2-3-4树的删除操作
     * 1、情况1：自己能搞定, 对应的叶子节点是3节点或者4节点
     * 2、情况2：自己搞不定, 需要兄弟节点借, 但是兄弟节点不借, 找父亲节点借，父节点下来, 然后兄弟节点代替父亲节点
     * 3、情况3：跟兄弟节点借, 兄弟节点也没有
     * @param node
     */
    private void fixAfterDeletion(Node<K,V> node) {
        //情况2和3
        while (node != null && colorOf(node) == BLACK){
            //如果当前替换节点是父节点的左子节点
            if(node == leftOf(parentOf(node))){
                //查找兄弟节点
                Node<K, V> rNode = rightOf(parentOf(node));
                if(colorOf(rNode) == RED){
                    //不是真正的兄弟节点
                    setColor(rNode, BLACK);
                    setColor(parentOf(node), RED);
                    leftRotate(parentOf(node));
                    rNode = rightOf(parentOf(node));
                }
                if(colorOf(leftOf(rNode)) == BLACK && colorOf(rightOf(rNode)) == BLACK){
                    //情况3：跟兄弟节点借, 兄弟节点没得借
                    setColor(rNode, RED);
                    node = parentOf(node);
                }else {
                    //情况2：跟兄弟节点借, 兄弟节点有得借
                    if(colorOf(rightOf(rNode)) == BLACK){
                        //不存在右孩子, 肯定存在左孩子
                        setColor(rNode, RED);
                        setColor(leftOf(rNode), BLACK);
                        rightRotate(rNode);
                        rNode = rightOf(parentOf(node));
                    }
                    setColor(rNode, colorOf(parentOf(node)));
                    setColor(parentOf(node), BLACK);
                    setColor(rightOf(rNode), BLACK);
                    leftRotate(parentOf(node));
                    node = root;
                }
            }else {//如果当前替换节点是父节点的右子节点
                //查找兄弟节点
                Node<K, V> rNode = leftOf(parentOf(node));
                if(colorOf(rNode) == RED){
                    //不是真正的兄弟节点
                    setColor(rNode, BLACK);
                    setColor(parentOf(node), RED);
                    rightRotate(parentOf(node));
                    rNode = leftOf(parentOf(node));
                }
                if(colorOf(leftOf(rNode)) == BLACK && colorOf(rightOf(rNode)) == BLACK){
                    //情况3：跟兄弟节点借, 兄弟节点没得借
                    setColor(rNode, RED);
                    node = parentOf(node);
                }else {
                    //情况2：跟兄弟节点借, 兄弟节点有得借
                    if(colorOf(leftOf(rNode)) == BLACK){
                        //不存在右孩子, 肯定存在左孩子
                        setColor(rNode, RED);
                        setColor(rightOf(rNode), BLACK);
                        leftRotate(rNode);
                        rNode = leftOf(parentOf(node));
                    }
                    setColor(rNode, colorOf(parentOf(node)));
                    setColor(parentOf(node), BLACK);
                    setColor(leftOf(rNode), BLACK);
                    rightRotate(parentOf(node));
                    node = root;
                }
            }
        }
        //情况1：替代的节点是红色, 则直接设置为黑色即可
        setColor(node, BLACK);
    }


    /**
     * 销毁红黑树, 递归调用销毁红黑树的节点
     * @param node
     */
    private void destroy(Node<K, V> node) {
        //递归结束条件
        if (node == null){
            return ;
        }

        //递归调用，销毁当前节点的左子树
        if (node.left != null){
            destroy(node.left);
        }

        //递归调用，销毁当前节点的右子树
        if (node.right != null){
            destroy(node.right);
        }

        node = null;
    }


    /**
     * 销毁红黑树
     */
    public void clear() {
        destroy(root);
        root = null;
    }

    /**
     * 计算整个树的最大深度
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * 计算指定树node的最大深度
     * @param node
     * @return
     */
    private int maxDepth(Node<K, V> node) {
        if(node == null) {
            return 0;
        }

        //1.计算左子树的最大深度；
        int maxL = maxDepth(node.left);

        //2.计算右子树的最大深度；
        int maxR = maxDepth(node.right);

        return (Math.max(maxL, maxR)) + 1;
    }
}
