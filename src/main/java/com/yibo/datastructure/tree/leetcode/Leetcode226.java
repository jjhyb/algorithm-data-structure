package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

/**
 * @Author: huangyibo
 * @Date: 2025/9/11 22:44
 * @Description: 翻转二叉树——翻转二叉树的左右子节点
 */
public class Leetcode226 {

    public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        flip(root);
        return root;
    }

    public void flip(TreeNode<Integer> node) {
        if(node == null){
            return;
        }
        TreeNode<Integer> temp = node.left;
        node.left = node.right;
        node.right = temp;

        flip(node.left);
        flip(node.right);
    }
}
