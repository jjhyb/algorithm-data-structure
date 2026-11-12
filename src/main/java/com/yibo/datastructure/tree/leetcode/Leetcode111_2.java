package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: huangyibo
 * @Date: 2025/9/11 0:15
 * @Description: 二叉树的最小深度——层序遍历求解
 */
public class Leetcode111_2 {

    /**
     * 遇到的第一个叶子节点所在层就是最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> poll = queue.poll();
                if(poll.left == null && poll.right == null){
                    return depth;
                }
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
