package com.yibo.datastructure.queue;

/**
 * @Author: huangyibo
 * @Date: 2021/12/26 22:15
 * @Description:
 */
public class ArrayQueue<E> implements Queue<E> {

    private E[] data;

    private int size;

    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取队列的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    @Override
    public void enqueue(E e) {
        addLast(e);
    }

    @Override
    public E dequeue() {
        return removeFirst();
    }

    @Override
    public E getFront() {
        return get(0);
    }

    /**
     * 获取指定索引位置的值
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. index is illegal.");
        }
        return data[index];
    }

    /**
     * 数组尾部新增元素
     * @param e
     */
    private void addLast(E e){
        add(size, e);
    }

    /**
     * 在指定位置插入元素
     * @param index
     * @param e
     */
    private void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("AddLast failed. require index >=0 and index <= size");
        }
        if(size == data.length){
            //扩容
            resize(2 * data.length);
        }

        for(int i = size - 1; i >= index; i --){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 数组扩容
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 删除数组中第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除栈数组中index位置的元素, 并返回删除的元素
     * @param index
     * @return
     */
    private E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. index is illegal.");
        }
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size --;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0){
            //当数组长度缩小为原数组的4分之一的时候才进行数组的缩容，
            //缩小为原数组的2分之一，预留空间，防止有数据添加导致扩容浪费性能
            resize(data.length / 2);
        }
        return ret;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
