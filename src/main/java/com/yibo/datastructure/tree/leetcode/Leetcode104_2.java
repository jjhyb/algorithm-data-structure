package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

import java.util.LinkedList;

/**
 * @Author: huangyibo
 * @Date: 2025/9/10 23:33
 * @Description: 二叉树的最大深度——使用后续遍历(非递归)求解
 */
public class Leetcode104_2 {

    /**
     *     思路：
     *     1. 使用非递归后序遍历, 栈的最大高度即为最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode<Integer> root) {
        TreeNode<Integer> cur = root;
        TreeNode<Integer> pop = null;
        LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
        //栈的最大高度树的深度
        int max = 0;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                int size = stack.size();
                if(size > max){
                    max = size;
                }
                cur = cur.left;
            } else {
                TreeNode<Integer> peek = stack.peek();
                if(peek.right == null || peek.right == pop){
                    pop = stack.pop();
                } else {
                    cur = peek.right;
                }
            }
        }
        return max;
    }
}
