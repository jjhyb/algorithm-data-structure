package com.yibo.datastructure.set;

/**
 * @Author: huangyibo
 * @Date: 2022/2/13 18:43
 * @Description: 基于二分搜索树实现的集合
 */
public class BSTSet <E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;

    public BSTSet(){
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
