package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: huangyibo
 * @Date: 2025/9/10 23:48
 * @Description: 二叉树的最大深度——使用层序遍历
 */
public class Leetcode104_3 {

    /**
     *     思路：
     *     1. 使用层序遍历, 层数即最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
            depth ++;
        }
        return depth;
    }
}
