package com.yibo.datastructure.maxheap;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2025/8/10 23:31
 * @Description:
 */

@SuppressWarnings("all")
public class MaxHeap1<E extends Comparable<E>> {

    private Object[] array;
    private int size;
    private int capacity;

    public MaxHeap1(int capacity) {
        this.array = new Object[capacity];
        this.capacity = capacity;
        this.size = capacity;
    }

    public MaxHeap1(E[] array) {
        this.array = array;
        this.capacity = array.length;
        this.size = array.length;
        heapify();
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public E peek(){
        return (E) array[0];
    }

    /**
     * 删除堆顶元素
     * @return
     */
    public E poll(){
        E e = (E) array[0];
        //头尾元素交换
        swap(0, size - 1);
        size--;
        //索引0位置的元素下潜
        siftDown(0);
        return e;
    }

    /**
     * 删除指定索引位置的元素
     * @param index
     * @return
     */
    public E poll(int index){
        E e = (E) array[index];
        //index索引位置元素和尾部元素交换
        swap(index, size - 1);
        size--;
        //索引index位置的元素下潜
        siftDown(index);
        return e;
    }

    /**
     * 替换堆顶元素
     * @param e
     */
    public void replace(E e){
        array[0] = e;
        //索引0位置的元素下潜
        siftDown(0);
    }

    /**
     * 堆的尾部添加元素
     * @return
     */
    public void offer(E e){
        if(size == capacity){
            expandCapacity();
        }
        array[size] = e;
        siftUp(size);
        size++;
    }

    private void heapify(){
        //找到堆的最后非叶子节点 size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * index索引位置元素上浮, 直到index索引位置元素小于父元素或堆顶
     * @param k
     */
    private void siftUp(int index){
        int child = index;
        while (child > 0) {
            //父元素的索引
            int parent = (child - 1) / 2;
            if(((E) array[child]).compareTo((E) array[parent]) > 0){
                swap(child, parent);
            } else {
                break;
            }
            child = parent;
        }
    }

    /**
     * parent索引元素比左右孩子节点元素小，则交换位置，不断循环
     * @param k
     */
    private void siftDown(int parent){
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if(left < size && ((E) array[left]).compareTo((E) array[max]) > 0){
            max = left;
        }
        if(right < size && ((E) array[right]).compareTo((E) array[max]) > 0){
            max = right;
        }
        //说明 左右孩子有节点比 parent 节点元素更大
        if(max != parent){
            swap(max, parent);
            //继续递归，进行比对
            siftDown(max);
        }
    }

    /**
     * 数组索引元素交换
     * @param i
     * @param j
     */
    private void swap(int i, int j){
        E temp = (E) array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isFull(){
        return size == array.length;
    }

    public int getSize(){
        return size;
    }

    /**
     * 动态扩容：当堆空间不足时，将容量扩大0.5，并复制原数据到新数组中
     */
    private void expandCapacity() {
        int newCapacity = capacity + (capacity >> 1);
        array = Arrays.copyOf(array, newCapacity);
        capacity = newCapacity;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }
}
