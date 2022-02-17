package com.yibo.datastructure.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: huangyibo
 * @Date: 2022/2/7 23:42
 * @Description: 二分搜索树
 */

public class BinarySearchTree<E extends Comparable<E>> {

    //二分搜索树节点类
    private class Node<E extends Comparable<E>>{

        public E e;

        public Node<E> left;

        public Node<E> right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 根节点
    private Node<E> root;

    // 树容量
    private Integer size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    /**
     * 获取元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回二分搜索树是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树添加新的元素
     * @param e
     */
    public void add(E e){
        //向根节点添加元素e
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * @param node
     * @param e
     * @return 返回插入新元素的二分搜索树的根
     */
    private Node<E> add(Node<E> node, E e){
        if(node == null){
            size ++;
            return new Node<>(e);
        }

        //递归调用，元素添加到node.left
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            //递归调用，元素添加到node.right
            node.right = add(node.right, e);
        }
        //返回当前根节点
        return node;
    }

    /**
     * 查看二分搜索树是否包含元素
     * @param e
     * @return
     */
    public boolean contains(E e){

        return contains(root, e);
    }

    /**
     * 查看以node为根的二分搜索树中是否包含元素e，递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node<E> node, E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     * @param node
     */
    private void preOrder(Node<E> node){
        // 递归终止条件
        if(node == null){
            return;
        }
        // 1. 前序遍历先访问当前节点
        System.out.println(node.e);
        // 2. 前序遍历访问左孩子
        preOrder(node.left);
        // 3. 前序遍历访问右孩子
        preOrder(node.right);
    }

    /**
     * 二分搜索树的非递归前序遍历
     */
    public void preOrderNR(){
        Stack<Node<E>> stack = new Stack();
        // 首先将根节点压入栈
        stack.push(root);
        while (!stack.isEmpty()){
            Node<E> cur = stack.pop();
            // 前序遍历当前节点
            System.out.println(cur.e);
            // 由于栈是后入先出, 前序遍历是先左孩子, 再右孩子, 所以这里需要先将右孩子压入栈
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     * 中序遍历指的是访问当前元素的顺序放在访问左右子节点之间
     * 中序遍历的结果是有序的
     * @param node
     */
    private void inOrder(Node<E> node){
        // 递归终止条件
        if(node == null){
            return;
        }
        // 1. 中序遍历访问左孩子
        inOrder(node.left);
        // 2. 中序遍历访问当前节点
        System.out.println(node.e);
        // 3. 中序遍历访问右孩子
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     * 后序遍历指的是访问当前元素的顺序放在访问左右子节点之后
     * @param node
     */
    private void postOrder(Node<E> node){
        // 递归终止条件
        if(node == null){
            return;
        }
        // 1. 后序遍历访问左孩子
        postOrder(node.left);
        // 2. 后序遍历访问右孩子
        postOrder(node.right);
        // 3. 后序遍历访问当前节点
        System.out.println(node.e);
    }

    /**
     * 二分搜索树的层序遍历
     * 层序遍历, 从左到右一层一层遍历, 借助队列实现
     */
    public void levelOrder(){
        // LinkedList实现了Queue接口
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<E> cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树中的最小元素, 递归方式
     * @return
     */
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node<E> minimum(Node<E> node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树中的最小元素, 非递归方式
     * @return
     */
    public E minimumNR(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        Node<E> cur = root;
        while (cur.left != null){
            cur = cur.left;
        }
        return cur.e;
    }

    /**
     * 寻找二分搜索树中的最小元素, 递归方式
     * @return
     */
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node<E> maximum(Node<E> node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 寻找二分搜索树中的最小元素, 非递归方式
     * @return
     */
    public E maximumNR(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        Node<E> cur = root;
        while (cur.right != null){
            cur = cur.right;
        }
        return cur.e;
    }

    /**
     * 从二分搜索树中删除最小值所在节点，并返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点，
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node<E> removeMin(Node<E> node){
        if(node.left == null){
            Node<E> rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        //递归调用node.left
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点，并返回最大值
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最大节点，
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node<E> removeMax(Node<E> node){
        if(node.right == null){
            Node<E> rightNode = node.left;
            node.left = null;
            size --;
            return rightNode;
        }
        //递归调用node.right
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归递归方式
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node<E> remove(Node<E> node, E e){
        //节点为空，直接返回
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            //待删除元素小于当前节点，向左递归寻找
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            //待删除元素大于当前节点，向右递归寻找
            node.right = remove(node.right, e);
            return node;
        }else {
            //待删除节点左子树为空
            if(node.left == null){
                Node<E> rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            //待删除节点右子树为空
            if(node.right == null){
                Node<E> rightNode = node.left;
                node.left = null;
                size --;
                return rightNode;
            }

            //待删除节点左、右子树不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树最小节点
            //用这个节点顶替待删除节点的位置

            //找到比待删除节点大的最小节点，即待删除节点右子树最小节点
            Node<E> successor = minimum(node.right);
            //删除比待删除节点大的最小节点，并将返回值给succeer的右孩子
            successor.right = removeMin(node.right);
            //node.left赋值给successor.left
            successor.left = node.left;
            //node节点和二分搜索树脱离关系
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node<E> node, int depth, StringBuilder res) {
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
