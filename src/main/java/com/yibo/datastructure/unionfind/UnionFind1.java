package com.yibo.datastructure.unionfind;

/**
 * @Author: huangyibo
 * @Date: 2022/2/26 14:11
 * @Description: 并查集 第一版的Union-Find
 */

public class UnionFind1 implements IUnionFind {

    private int[] id;

    public UnionFind1(int size){
        this.id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素所对应的集合编号
     * @param p
     * @return
     */
    private int find(int p){
        if(p < 0 || p >= id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    /**
     * 查看元素p和元素q是否是否所属一个集合
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
        int pId = find(p);
        int qId = find(q);

        //待合并的两个编号在同一个集合中，无需任何操作
        if(pId == qId){
            return;
        }

        for(int i=0;i<id.length;i++){
            //将pId所有元素的id都改为qId
            if(id[i] == pId){
                id[i] = qId;
            }
        }
    }
}
