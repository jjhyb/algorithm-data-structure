package com.yibo.datastructure.tree;

/**
 * @Author: huangyibo
 * @Date: 2025/9/2 23:16
 * @Description:
 */

public class TreeNode<E> {

    public E data;              // 节点数据
    public TreeNode<E> left;    // 左子节点
    public TreeNode<E> right;   // 右子节点
    public TreeNode<E> parent;  // 父节点

    public TreeNode(E data, TreeNode<E> parent) {
        this.data = data;
        this.parent = parent;
    }

}
