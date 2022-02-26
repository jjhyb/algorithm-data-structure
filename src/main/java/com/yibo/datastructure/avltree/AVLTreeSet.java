package com.yibo.datastructure.avltree;

/**
 * @Author: huangyibo
 * @Date: 2022/2/27 0:52
 * @Description: AVLTreeSet 底层基于AVLTree
 */

public class AVLTreeSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E, Object> avlTree;

    public AVLTreeSet(){
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avlTree.add(e, null);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
