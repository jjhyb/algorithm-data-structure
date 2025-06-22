package com.yibo.datastructure.stack;

import java.util.Iterator;

/**
 * @Author: huangyibo
 * @Date: 2025/4/24 0:18
 * @Description:
 * 数组作为栈实现
 *          底           顶
 *  索引    0    1   2   3
 *  元素    a    b   c   d
 */
public class ArrayStack1<E> implements Stack1<E>, Iterable<E> {

    private E[] array;

    //栈顶指针
    private int top;

    public ArrayStack1(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E e) {
        if(isFull()){
            return false;
        }
        array[top] = e;
        top ++;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        E value = array[top - 1];
        top -- ;
        return value;

    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public int getSize() {
        return top;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int temp = top;
            @Override
            public boolean hasNext() {
                return temp > 0;
            }

            @Override
            public E next() {
                return array[--temp];
            }
        };
    }
}
