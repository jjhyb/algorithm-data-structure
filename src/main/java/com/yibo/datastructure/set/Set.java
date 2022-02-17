package com.yibo.datastructure.set;

/**
 * @Author: huangyibo
 * @Date: 2022/2/13 18:27
 * @Description: 集合接口
 */
public interface Set<E> {

    /**
     * 添加元素
     * @param e
     */
    void add(E e);

    /**
     * 删除元素
     * @param e
     */
    void remove(E e);

    /**
     * 集合是否包含元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 集合的元素个数
     * @return
     */
    int getSize();

    /**
     * 集合是否为空
     * @return
     */
    boolean isEmpty();
}
