package com.yibo.datastructure.map;

/**
 * @Author: huangyibo
 * @Date: 2022/2/15 20:34
 * @Description: 映射接口
 */


public interface Map<K, V> {

    /**
     * 添加元素
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 删除元素，返回元素对应的value
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 是否包含key
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 修改元素key对应的value
     * @param key
     * @param value
     */
    void set(K key, V value);

    /**
     * 获取key对应的value
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 映射的元素个数
     * @return
     */
    int getSize();

    /**
     * 映射是否为空
     * @return
     */
    boolean isEmpty();
}
