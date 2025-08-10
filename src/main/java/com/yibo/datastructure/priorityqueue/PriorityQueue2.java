package com.yibo.datastructure.priorityqueue;

import com.yibo.datastructure.queue.Queue1;

/**
 * @Author: huangyibo
 * @Date: 2025/7/6 18:45
 * @Description:
 * 基于有序数组实现
 * 队列中元素类型, 必须实现 Priority 接口
 */

@SuppressWarnings("all")
public class PriorityQueue2<E extends Priority> implements Queue1<E> {

    Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
        this.array = new Priority[capacity];
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        if(isFull()){
            return false;
        }
        insert(e);
        size++;
        return true;
    }

    /**
     * 倒序进行插入
     * @param e
     */
    private void insert(E e){
        int i = size - 1;
        while (i >= 0 && array[i].priority() > e.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = e;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E e = (E) array[size - 1];
        array[--size] = null;
        return e;
    }


    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return (E) array[size - 1];
    }



    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

}
