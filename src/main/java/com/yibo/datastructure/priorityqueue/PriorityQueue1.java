package com.yibo.datastructure.priorityqueue;

import com.yibo.datastructure.queue.Queue1;

/**
 * @Author: huangyibo
 * @Date: 2025/7/6 18:45
 * @Description:
 * 基于无序数组实现
 * 队列中元素类型, 必须实现 Priority 接口
 */

@SuppressWarnings("all")
public class PriorityQueue1<E extends Priority> implements Queue1<E> {

    Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
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
        array[size++] = e;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        int max = selectMax();
        E e = (E) array[max];
        remove(max);
        return e;
    }

    /**
     * 删除元素个数
     * @param index
     */
    private void remove(int index){
        if(index < size - 1){
            //不是数组最后一个元素，移动数组元素个数
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        array[--size] = null;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        int max = selectMax();
        return (E) array[max];
    }

    /**
     * 返回优先级最高的索引值
     * @return
     */
    private int selectMax(){
        int max = 0;
        for (int i = 1; i < size; i++) {
            if(array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
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
