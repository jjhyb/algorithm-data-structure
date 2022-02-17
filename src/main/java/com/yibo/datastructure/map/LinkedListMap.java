package com.yibo.datastructure.map;

/**
 * @Author: huangyibo
 * @Date: 2022/2/15 20:39
 * @Description: 基于链表实现映射
 */

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node<K, V>{
        public K key;

        public V value;

        public Node<K, V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key.toString() +" : " + value.toString();
        }
    }

    private Node<K, V> dummyHead;

    private Integer size;

    public LinkedListMap(){
        dummyHead = new Node<>(null, null);
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取key对应的node，不存在返回null
     * @param key
     * @return
     */
    private Node<K, V> getNode(K key){
        Node<K, V> cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key){
        Node<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        Node<K, V> node = getNode(key);
        if(node != null){
            //key已存在，则更新
            node.value = value;
            return;
        }

        //key不存在，则新增
        Node<K, V> newNode = new Node<>(key, value);
        dummyHead.next = newNode.next = dummyHead.next;
        size ++;
    }

    @Override
    public void set(K key, V value) {
        Node<K, V> node = getNode(key);
        if(node == null){
            //不存在直接抛异常
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        //key已存在，则更新
        node.value = value;
    }

    @Override
    public V remove(K key) {
        Node<K, V> prev = dummyHead;
        //循环判断key是否存在
        while (prev.next != null) {
            if(prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }

        //如果key存在，则进行删除
        if(prev.next != null){
            Node<K, V> delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }

        //key不存在，返回null
        return null;
    }
}
