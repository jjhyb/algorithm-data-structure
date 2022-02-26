package com.yibo.datastructure.unionfind;

/**
 * @Author: huangyibo
 * @Date: 2022/2/26 15:08
 * @Description: 并查集 第五版的Union-Find
 */

public class UnionFind5 implements IUnionFind {

    //存储每一节点父节点值
    private int[] parent;

    //rank[i]表示以i为根的集合所表示的树的层数
    private int[] rank;

    public UnionFind5(int size){
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            //初始时每个节点自称一个集合所以父节点就是自己
            parent[i] = i;
            //初始化的时候每个节点都为根节点，且层数都为1
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找节点p的根节点 循环方式
     * 时间复杂度O(h)，h为树的高度
     * @param p
     * @return
     */
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parent[p]){
            ////路径压缩:将当前节点的父节点设置成父节点的父节点
            parent[p] = parent[parent[p]];
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

        //根据根节点所在树的rank层级来判断合并方向
        //rank层级矮的树往rank层级高的树合并不需要维护rank
        if(rank[pRoot] < rank[qRoot]){
            //将pRoot添加到qRoot中，成为qRoot的孩子
            parent[pRoot] = qRoot;
        }else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        } else { //rank[pRoot] = rank[qRoot]
            parent[qRoot] = pRoot;
            //只有rank相等的情况才需要维护rank
            //此时pRoot层数需要加1
            rank[pRoot] += 1;
        }
    }
}