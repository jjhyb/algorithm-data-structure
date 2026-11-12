package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

/**
 * @Author: huangyibo
 * @Date: 2025/9/10 22:27
 * @Description: 对称二叉树
 */
public class Leetcode101 {

    public boolean isSymmetric(TreeNode<Integer> root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode<Integer> left, TreeNode<Integer> right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.data != right.data){
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
