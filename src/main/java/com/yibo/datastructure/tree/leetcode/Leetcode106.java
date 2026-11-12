package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2025/9/11 23:22
 * @Description: 从中序与后序遍历序列构造二叉树
 */
public class Leetcode106 {

    /**
     * inorder = [4,2,1,6,3,7]
     * postorder = [4,2,6,7,3,1]
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode<Integer> buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        //创建根节点
        int rootVal = postorder[postorder.length-1];
        TreeNode<Integer> root = new TreeNode<>(rootVal, null);
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal){
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i+1, inorder.length);
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length-1);
                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }
}
