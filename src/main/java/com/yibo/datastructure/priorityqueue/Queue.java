package com.yibo.datastructure.priorityqueue;

/**
 * @Author: huangyibo
 * @Date: 2021/12/26 22:12
 * @Description:
 */
public interface Queue<E> {

    /**
     * 队列的容量
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向队列中添加元素
     * @param e
     */
    void enqueue(E e);

    /**
     * 向队列取出元素
     * @return
     */
    E dequeue();

    /**
     * 查看队列第一个元素
     * @return
     */
    E getFront();
}
