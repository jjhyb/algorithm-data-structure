package com.yibo.datastructure.queue.leetcode;

import com.yibo.datastructure.queue.LinkedListQueue;
import com.yibo.datastructure.queue.LinkedListQueue1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: huangyibo
 * @Date: 2025/4/22 20:37
 * @Description: 二叉树层序遍历
 *          1
 *         / \
 *        2   3
 *      / \  / \
 *     4  5 6   7
 */
public class Leetcode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //当前层节点数
        int c1 = 1;
        while (!queue.isEmpty()){
            //下一层节点数
            int c2 = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                    c2 ++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    c2 ++;
                }
            }
            result.add(list);
            c1 = c2;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        LinkedListQueue1<TreeNode>  queue = new LinkedListQueue1<>();
        queue.offer(root);
        //当前层节点数
        int c1 = 1;
        while (!queue.isEmpty()){
            //下一层节点数
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if(node.left != null){
                    queue.offer(node.left);
                    c2 ++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    c2 ++;
                }
            }
            System.out.println();
            c1 = c2;
        }
    }
}
