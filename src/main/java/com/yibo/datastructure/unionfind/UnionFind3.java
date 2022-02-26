package com.yibo.datastructure.unionfind;

/**
 * @Author: huangyibo
 * @Date: 2022/2/26 15:08
 * @Description: 并查集 第三版的Union-Find
 */

public class UnionFind3 implements IUnionFind {

    //存储每一节点父节点值
    private int[] parent;

    //sz[i]表示以i为根的集合中元素个数
    private int[] sz;

    public UnionFind3(int size){
        this.parent = new int[size];
        this.sz = new int[size];
        for (int i = 0; i < size; i++) {
            //初始时每个节点自称一个集合所以父节点就是自己
            parent[i] = i;
            //初始化的时候每个节点都为根节点，且元素都为1
            sz[i] = 1;
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

        //pRoot为根节点的元素小于qRoot为根节点的元素
        //让元素个数比较小的根节点指向原神个数比较多的根节点，减少根节点个数
        if(sz[pRoot] < sz[qRoot]){
            //将pRoot添加到qRoot中，成为qRoot的孩子
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }
}