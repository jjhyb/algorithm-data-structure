package com.yibo.datastructure.queue;

import java.util.Iterator;

/**
 * @Author: huangyibo
 * @Date: 2025/6/22 19:12
 * @Description: 基于循环数组实现
 * tail 停下来的位置不存储, 会浪费一个位置
 *
 *  h -- head    头指针
 *  t -- tail    尾指针
 *
 *           t   h
 *  0    1   2   3
 *  a    b       c
 *
 *  offerLast(a)    先添加元素 在tail++
 *  offerLast(b)
 *  offerFirst(c)   先head-- 在添加元素
 *
 *  pollFirst()     先获取要移除的值, 在head++
 *  pollLast()      先tail-- 在获取要移除的值
 *
 *  head == tail 队列为空
 *  head ~ tail == 数组长度 - 1 队列满了
 */

public class ArrayDeque<E> implements Deque<E>, Iterable<E> {

    E[] array;
    int size;
    int head;
    int tail;

    @SuppressWarnings("all")
    public ArrayDeque(int capacity) {
        this.array = (E[]) new Object[capacity + 1];
        this.size = 0;
    }

    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        head = dec(head, array.length);
        array[head] = e;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        array[tail] = e;
        tail = inc(tail, array.length);
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        E e = array[head];
        array[head] = null;
        head = inc(head, array.length);
        size--;
        return e;
    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        tail = dec(tail, array.length);
        size--;
        E e = array[tail];
        array[tail] = null;
        return e;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        tail = dec(tail, array.length);
        return array[tail];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if(tail > head) {
            return tail - head == array.length - 1;
        }
        if(tail < head){
            return head - tail == 1;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int temp = head;
            @Override
            public boolean hasNext() {
                return temp != tail;
            }

            @Override
            public E next() {
                E e = array[temp];
                temp = inc(temp, array.length);
                return e;
            }
        };
    }

    static int inc(int i, int length){
        if(i + 1 >= length){
            return 0;
        }
        return i + 1;
    }

    static int dec(int i, int length){
        if(i - 1 < 0){
            return length - 1;
        }
        return i - 1;
    }
}
