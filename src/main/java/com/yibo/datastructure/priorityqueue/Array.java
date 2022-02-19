package com.yibo.datastructure.priorityqueue;

/**
 * @Author: huangyibo
 * @Date: 2021/12/25 17:29
 * @Description: 动态数组实现
 */

public class Array<E> {

    private E[] data;

    private int size;

    public Array(){
        this(10);
    }

    public Array(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array(E[] arr){
        this.data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        this.size = arr.length;
    }

    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 数组尾部新增元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 数组头部新增元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在指定位置插入元素
     * @param index
     * @param e
     */
    public void add(int index, E e){
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
     * 替换指定索引位置的值
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 数组是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引,不存在元素e,返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中index位置的元素, 并返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
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

    /**
     * 删除数组中第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    /**
     * 数组索引元素交换
     * @param i
     * @param j
     */
    public void swap(int i, int j){
        if(i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("Index is illegal.");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
