package com.yibo.datastructure.queue.leetcode;

import com.yibo.datastructure.queue.LinkedListQueue1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: huangyibo
 * @Date: 2025/6/22 23:56
 * @Description: 二叉树 Z字层序遍历
 */
public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //当前层节点数
        int c1 = 1;
        //当前层级是否是奇数层
        boolean old = true;
        while (!queue.isEmpty()){
            //下一层节点数
            int c2 = 0;
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                if(old){
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if(node.left != null){
                    queue.offer(node.left);
                    c2 ++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    c2 ++;
                }
            }
            old = !old;
            result.add(level);
            c1 = c2;
        }
        return result;
    }
}
