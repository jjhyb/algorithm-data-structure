package com.yibo.datastructure.queue;

import java.util.HashMap;
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
public class ArrayQueue3<E> implements Queue1<E>, Iterable<E>{

    private final E[] array;
    private int head = 0;
    private int tail = 0;
    //队列中的元素个数
    private int size = 0;

    public ArrayQueue3(int capacity){
        /*if((capacity & (capacity - 1)) != 0){
            throw new IllegalArgumentException("队列初始化大小必须为2的N次方");
        }*/
        //保证数组的长度为2的N次方
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n += 1;
        array = (E[]) new Object[n];
    }

    @Override
    public boolean offer(E e) {
        if(isFull()){
            return false;
        }
        array[tail & (array.length - 1)] = e;
        tail ++;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E e = array[head & (array.length - 1)];
        head ++;
        size--;
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[head & (array.length - 1)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail - head) == array.length;
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
                return p != tail;
            }

            @Override
            public E next() {
                E e = array[p & (array.length - 1)];
                p ++;
                return e;
            }
        };
    }
}
