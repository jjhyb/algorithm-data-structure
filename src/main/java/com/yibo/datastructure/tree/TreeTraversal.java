package com.yibo.datastructure.tree;

import java.util.LinkedList;

/**
 * @Author: huangyibo
 * @Date: 2025/9/2 23:20
 * @Description:
 */
public class TreeTraversal<E> {

    /**
     * 前序遍历——递归
     *  * 先访问该节点
     *  * 然后是左子树
     *  * 然后是右子树
     * @param treeNode
     */
    public void preOrder(TreeNode<E> treeNode) {
        if(treeNode.data == null){
            return;
        }
        // 先输出当前节点值
        System.out.print(treeNode.data + "\t");
        // 递归向左子树前序遍历
        preOrder(treeNode.left);
        // 递归向右子树前序遍历
        preOrder(treeNode.right);
    }

    /**
     * 前序遍历——非递归
     *  * 先访问该节点
     *  * 然后是左子树
     *  * 然后是右子树
     * @param treeNode
     */
    public void preOrderNor(TreeNode<E> treeNode) {
        LinkedList<TreeNode<E>> stack = new LinkedList<>();
        TreeNode<E> cur = treeNode;
        while (!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                System.out.println(cur.data + "\t");
                cur = cur.left;
            } else {
                TreeNode<E> pop = stack.pop();
                cur = pop.right;
            }
        }
    }

    /**
     * 中序遍历——递归
     *  * 先访问左子树
     *  * 然后是该节点
     *  * 然后是右子树
     * @param treeNode
     */
    public void inOrder(TreeNode<E> treeNode) {
        if(treeNode.data == null){
            return;
        }
        // 递归向左子树中序遍历
        preOrder(treeNode.left);
        // 输出当前节点值
        System.out.print(treeNode.data + "\t");
        // 递归向右子树中序遍历
        preOrder(treeNode.right);
    }

    /**
     * 中序遍历——非递归
     *  * 先访问左子树
     *  * 然后是该节点
     *  * 然后是右子树
     * @param treeNode
     */
    public void inOrderNor(TreeNode<E> treeNode) {
        LinkedList<TreeNode<E>> stack = new LinkedList<>();
        TreeNode<E> cur = treeNode;
        while (!stack.isEmpty() || cur != null) {
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode<E> pop = stack.pop();
                System.out.println(pop.data + "\t");
                cur = pop.right;
            }
        }
    }

    /**
     * 后续遍历——递归
     *  * 先访问左子树
     *  * 然后是右子树
     *  * 最后是该节点
     * @param treeNode
     */
    public void postOrder(TreeNode<E> treeNode) {
        if(treeNode.data == null){
            return;
        }
        // 递归向左子树后序遍历
        preOrder(treeNode.left);
        // 递归向右子树后序遍历
        preOrder(treeNode.right);
        // 输出当前节点值
        System.out.print(treeNode.data + "\t");
    }

    /**
     * 后续遍历——非递归
     *  * 先访问左子树
     *  * 然后是右子树
     *  * 最后是该节点
     * @param treeNode
     */
    public void postOrderNor(TreeNode<E> treeNode) {
        LinkedList<TreeNode<E>> stack = new LinkedList<>();
        TreeNode<E> cur = treeNode;
        //最近一次弹栈的元素
        TreeNode<E> pop = null;
        while (!stack.isEmpty() || cur != null) {
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                //栈顶元素
                TreeNode<E> peek = stack.peek();
                if(peek.right == null || peek.right == pop){
                    pop = stack.pop();
                    System.out.println(pop.data + "\t");
                } else {
                    cur = peek.right;
                }
            }
        }
    }

    public void orderNor(TreeNode<E> treeNode) {
        LinkedList<TreeNode<E>> stack = new LinkedList<>();
        TreeNode<E> cur = treeNode;
        //最近一次弹栈的元素
        TreeNode<E> pop = null;
        while (!stack.isEmpty() || cur != null) {
            if(cur != null){
                stack.push(cur);
                System.out.println("前序遍历: " + cur.data + "\t");
                //处理左子树
                cur = cur.left;
            } else {
                //栈顶元素
                TreeNode<E> peek = stack.peek();
                //没有右子树
                if(peek.right == null){
                    System.out.println("中序遍历: " + peek.data + "\t");
                    pop = stack.pop();
                    System.out.println("后序遍历: " + pop.data + "\t");
                } else if (peek.right == pop) {
                    //右子树处理完成
                    pop = stack.pop();
                    System.out.println("后序遍历: " + pop.data + "\t");
                } else {
                    System.out.println("中序遍历: " + peek.data + "\t");
                    //处理右子树
                    cur = peek.right;
                }
            }
        }
    }
}
