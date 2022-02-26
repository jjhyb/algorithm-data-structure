package com.yibo.datastructure.unionfind;

/**
 * @Author: huangyibo
 * @Date: 2022/2/26 14:11
 * @Description: 并查集接口
 */

public interface IUnionFind {

    /**
     * 用来确定两个元素是否属于同一集合
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p,int q);

    /**
     * 将两个元素所在的集合并成同一个集合
     * @param p
     * @param q
     */
    void unionElements(int p,int q);

    /**
     * 并查集一共右多少个元素
     * @return
     */
    int getSize();
}
