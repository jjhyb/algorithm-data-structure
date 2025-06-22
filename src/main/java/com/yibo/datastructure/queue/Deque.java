package com.yibo.datastructure.queue;

/**
 * @Author: huangyibo
 * @Date: 2025/5/11 23:56
 * @Description: 双端队列接口
 */
public interface Deque<E> {

    /**
     * 向队列头部插入元素
     * @param e 带插入值
     * @return 插入成功返回true, 插入失败返回false
     */
    boolean offerFirst(E e);

    /**
     * 向队列尾部插入元素
     * @param e 带插入值
     * @return 插入成功返回true, 插入失败返回false
     */
    boolean offerLast(E e);

    /**
     * 从队列头获取值，并移除
     * @return 如果队列非空返回队列头部元素，否则返回null
     */
    E pollFirst();

    /**
     * 从队列尾部获取值，并移除
     * @return 如果队列非空返回队列尾部元素，否则返回null
     */
    E pollLast();

    /**
     * 从队列头部获取值，不移除元素
     * @return 如果队列非空返回队列头部元素，否则返回null
     */
    E peekFirst();

    /**
     * 从队列尾部获取值，不移除元素
     * @return 如果队列非空返回队列尾部元素，否则返回null
     */
    E peekLast();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列是否已满
     * @return
     */
    boolean isFull();

    /**
     * 队列的容量
     * @return
     */
    int getSize();
}
