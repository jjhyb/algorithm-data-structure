package com.yibo.datastructure.hashtable;

import java.util.TreeMap;

/**
 * @Author: huangyibo
 * @Date: 2022/3/12 22:08
 * @Description: hash表
 */

public class HashTable<K, V> {

    private static final int uppperTol = 10;

    private static final int lowerTol = 2;

    private static final int initCapacity = 8;

    private TreeMap<K, V>[] hashtable;

    private int capacity;

    private int size;

    public HashTable(){
        this(initCapacity);
    }

    public HashTable(int capacity){
        this.capacity = capacity;
        size = 0;
        hashtable = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    /**
     * 计算key在hash表中的数组索引
     * @param key
     * @return
     */
    private int hash(K key) {
        int h;
        h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        return (h & 0x7fffffff) % capacity;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        boolean containsKey = treeMap.containsKey(key);
        treeMap.put(key, value);
        if(!containsKey){
            size ++;
        }
        if(size >= uppperTol * capacity){
            resize(2 * capacity);
        }
    }

    public V remove(K key){
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        V result = null;
        if(treeMap.containsKey(key)){
            result = treeMap.remove(key);
            size --;
            if(size < lowerTol * capacity && capacity / 2 >= initCapacity){
                resize(capacity / 2);
            }
        }
        return result;
    }

    public void set(K key, V value){
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if(treeMap.containsKey(key)){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        treeMap.put(key, value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newCap) {
        TreeMap<K, V>[] newTreeMap = new TreeMap[newCap];
        for (int i = 0; i < newCap; i++) {
            newTreeMap[i] = new TreeMap<>();
        }

        int oldCap = capacity;
        this.capacity = newCap;
        for (int i = 0; i < oldCap; i++) {
            TreeMap<K, V> treeMap = hashtable[i];
            treeMap.forEach((key, value) -> {
                newTreeMap[hash(key)].put(key, treeMap.get(key));
            });
        }
        this.hashtable = newTreeMap;
    }
}
