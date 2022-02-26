package com.yibo.datastructure.avltree;

/**
 * @Author: huangyibo
 * @Date: 2022/2/27 0:47
 * @Description: AVLTreeMap 底层基于AVLTree
 */

public class AVLTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K,V> avlTree;

    public AVLTreeMap(){
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key,value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key, value);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
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
