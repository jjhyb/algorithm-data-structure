package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

/**
 * @Author: huangyibo
 * @Date: 2025/9/11 0:07
 * @Description: 二叉树的最小深度——后序遍历求解
 */
public class Leetcode111_1 {

    public int minDepth(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        int d1 = minDepth(root.left);
        int d2 = minDepth(root.right);
        //当左子树为null
        if(d1 == 0){
            //返回右子树深度+1
            return d2 + 1;
        }
        //当右子树为null
        if(d2 == 0){
            //返回左子树深度+1
            return d1 + 1;
        }
        return Integer.min(d1, d2) + 1;
    }
}
