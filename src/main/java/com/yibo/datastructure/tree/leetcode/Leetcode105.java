package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2025/9/11 23:05
 * @Description: 从前序与中序遍历序列构造二叉树
 *
 */
public class Leetcode105 {

    /**
     * preorder = [1,2,4,3,6,7]
     * inorder = [4,2,1,6,3,7]
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        //创建根节点
        int rootVal = preorder[0];
        TreeNode<Integer> root = new TreeNode<>(rootVal, null);
        //区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal){
                // 0 - i-1 左子树
                // i+1 - inorder.length-1 右子树
                //中续遍历的左右子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i+1, inorder.length);
                //前续遍历的左右子树
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i+1);
                int[] preRight = Arrays.copyOfRange(preorder, i+1, preorder.length);
                //给根节点的左右阶段赋值
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }
}
