package com.yibo.datastructure.stack;

/**
 * @Author: huangyibo
 * @Date: 2021/12/26 18:06
 * @Description:
 */
public interface Stack<E> {

    /**
     * 栈的容量
     * @return
     */
    int getSize();

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向栈中添加元素
     * @param e
     */
    void push(E e);

    /**
     * 向栈中取出元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶的元素
     * @return
     */
    E peek();
}
