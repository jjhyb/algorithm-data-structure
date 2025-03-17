package com.yibo.datastructure.queue;

import java.util.Iterator;

/**
 * @Author: huangyibo
 * @Date: 2025/3/17 19:48
 * @Description: 环形数组实现队列
 * head: 头指针，用于往数组中取出元素
 * tail: 尾指针，用于往数组中写入元素
 * size: 队列中的元素个数
 * 下一个待写入的索引值：(tail + 1) % array.length
 * 下一个待取出的索引值：(head + 1) % array.length
 * 队列为空的条件判断：size == 0
 * 队列满了的条件判断：size == array.length
 */
public class ArrayQueue2<E> implements Queue1<E>, Iterable<E>{

    private final E[] array;
    private int head = 0;
    private int tail = 0;
    //队列中的元素个数
    private int size = 0;

    public ArrayQueue2(int capacity){
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E e) {
        if(isFull()){
            return false;
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E e = array[head];
        head = (head + 1) % array.length;
        size--;
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E e = array[p];
                p = (p + 1) % array.length;
                count ++;
                return e;
            }
        };
    }
}
