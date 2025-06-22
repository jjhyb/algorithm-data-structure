package com.yibo.datastructure.stack;

/**
 * @Author: huangyibo
 * @Date: 2021/12/26 18:06
 * @Description:
 */
public interface Stack1<E> {

    /**
     *
     * @param e
     */
    /**
     * 向栈顶压入元素
     * @param e     待压入值
     * @return boolean
     */
    boolean push(E e);

    /**
     *
     * @return
     */
    /**
     * 向栈顶弹出元素
     * @return  栈非空返回栈顶元素，栈为空返回null
     */
    E pop();

    /**
     * 查看栈顶的元素
     * @return
     */
    /**
     * 返回栈顶元素不弹出
     * @return  栈非空返回栈顶元素，栈为空返回null
     */
    E peek();

    /**
     * 栈是否为空
     * @return 空返回true, 非空返回false
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * @return 栈已满返回true, 非空返回false
     */
    boolean isFull();

    /**
     * 栈的容量
     * @return
     */
    int getSize();


}
