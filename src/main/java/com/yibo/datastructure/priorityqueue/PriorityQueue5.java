package com.yibo.datastructure.priorityqueue;

import com.yibo.datastructure.queue.Queue1;

/**
 * @Author: huangyibo
 * @Date: 2025/7/6 18:45
 * @Description:
 * 基于 小顶堆 实现
 * 队列中元素类型, 必须实现 Comparable 接口
 */

@SuppressWarnings("all")
public class PriorityQueue5<E extends Comparable> implements Queue1<E> {

    E[] array;
    int size;

    public PriorityQueue5(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 1、入堆新元素, 加入到数组末尾(索引位置 child)
     * 2、不断比较新加元素与它父节点元素(parent)的优先级
     *      如果父节点优先级低, 则向下移动, 并找到下一个parent
     *      直至父节点优先级更高或 child = 0 为止
     * @param e 带插入值
     * @return
     */
    @Override
    public boolean offer(E e) {
        if(isFull()){
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && e.compareTo(array[parent]) < 0){
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = e;
        return true;
    }

    /**
     * 1、交换堆顶和尾部元素, 让尾部元素出队
     * 2、(下潜)
     *      从堆顶开始, 将父元素与两个孩子较大者交换
     *      直到父元素大于两个孩子, 或没有孩子为止
     * @return
     */
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        swap(0, size - 1);
        size--;
        E e = (E) array[size];
        array[size] = null;
        //下潜
        siftDown(0);
        return e;
    }

    private void siftDown(int parent){
        int left = 2 * parent + 1;
        int right = left + 1;
        //下设父元素优先级更高
        int min = parent;
        if(left < size && array[left].compareTo(array[min]) < 0){
            min = left;
        }
        if(right < size && array[right].compareTo(array[min]) < 0){
            min = right;
        }
        //有子节点比父节点大, 则交换位置
        if(min != parent) {
            swap(min, parent);
            // 递归调用, 重复进行节点比较
            siftDown(min);
        }
    }

    private void swap(int i, int j){
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return (E) array[0];
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
