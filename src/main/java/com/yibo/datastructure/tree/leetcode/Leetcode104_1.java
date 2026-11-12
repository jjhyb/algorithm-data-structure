package com.yibo.datastructure.tree.leetcode;

import com.yibo.datastructure.tree.TreeNode;

/**
 * @Author: huangyibo
 * @Date: 2025/9/10 22:38
 * @Description: 二叉树的最大深度
 */
public class Leetcode104_1 {

    /**
     *     思路：
     *     1. 得到左子树深度, 得到右子树深度, 二者最大者加一, 就是本节点深度
     *     2. 因为需要先得到左右子树深度, 很显然是后序遍历典型应用
     *     3. 关于深度的定义：从根出发, 离根最远的节点总边数,
     *         注意: 力扣里的深度定义要多一
     *
     *         深度2         深度3         深度1
     *         1            1            1
     *        / \          / \
     *       2   3        2   3
     *                         \
     *                          4
     * @param root
     * @return
     */
    public int maxDepth(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int d1 = maxDepth(root.left);
        int d2 = maxDepth(root.right);
        return Integer.max(d1, d2) + 1;
    }
}
