package com.yibo.datastructure.blockingqueue;

/**
 * @Author: huangyibo
 * @Date: 2025/8/10 15:32
 * @Description:
 */
public interface BlockingQueue<E> {

    void offer(E e) throws InterruptedException;

    Boolean offer(E e, long timeout) throws InterruptedException;

    E poll() throws InterruptedException;
}
