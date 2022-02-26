package com.yibo.datastructure.unionfind;

/**
 * @Author: huangyibo
 * @Date: 2022/2/26 14:41
 * @Description: 并查集 第二版的Union-Find
 */

public class UnionFind2 implements IUnionFind {

    //存储每一节点父节点值
    private int[] parent;

    public UnionFind2(int size){
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            //初始时每个节点自称一个集合所以父节点就是自己
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找节点p的根节点
     * 时间复杂度O(h)，h为树的高度
     * @param p
     * @return
     */
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看元素p和元素q是否是否所属一个集合
     * 时间复杂度O(h)，h为树的高度
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        //相同集合无需操作
        if(pRoot == qRoot){
            return;
        }

        //将pRoot添加到qRoot中，成为qRoot的孩子
        parent[pRoot] = qRoot;
    }
}
