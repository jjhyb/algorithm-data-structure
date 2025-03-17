package com.yibo.datastructure.queue;

/**
 * @Author: huangyibo
 * @Date: 2021/12/26 22:12
 * @Description:
 */
public interface Queue1<E> {

    /**
     * 向队列尾部插入元素
     * @param e 带插入值
     * @return 插入成功返回true, 插入失败返回false
     */
    boolean offer(E e);

    /**
     * 从队列头获取值，并移除
     * @return 如果队列非空返回队列头部元素，否则返回null
     */
    E poll();

    /**
     * 从队列头获取值，不移除元素
     * @return 如果队列非空返回队列头部元素，否则返回null
     */
    E peek();

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
