package com.yibo.datastructure.priorityqueue;

/**
 * @Author: huangyibo
 * @Date: 2022/2/17 22:54
 * @Description: 最大堆 完全二叉树，父亲节点大于等于孩子节点，采用数组表示
 */

public class MaxHeap<E extends Comparable<E>> {

    //这里使用数组作为底层实现
    private Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    /**
     * 将任意数组整理成堆的形状
     * @param arr
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        //从最后一个叶子节点的父节点开始进行siftDown操作,不断循环
        for(int i = parent(arr.length - 1); i >= 0; i --){
            siftDown(i);
        }
    }

    /**
     * 返回堆中的元素个数
     * @return
     */
    public int getSize(){
        return data.getSize();
    }

    /**
     *堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
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

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        //当前元素在数组中的索引为 data.getSize() - 1
        //比较当前元素和其父亲节点的元素，大于父亲节点元素则交换位置
        siftUp(data.getSize() - 1);
    }

    /**
     * k索引元素比父节点元素大，则交换位置，不断循环
     * @param k
     */
    private void siftUp(int k){
        //k > 0 并且k索引元素比父节点元素大，则交换位置，不断循环
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 查看堆中最大元素
     * @return
     */
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax(){
        //获取堆中最大元素
        E ret = findMax();

        //堆中最开始的元素和最后元素交换位置
        data.swap(0,data.getSize() - 1);

        //删除堆中最后一个元素
        data.removeLast();
        //0索引元素比左右孩子节点元素小，则交换位置，不断循环
        siftDown(0);
        return ret;
    }

    /**
     * k索引元素比左右孩子节点元素小，则交换位置，不断循环
     * @param k
     */
    private void siftDown(int k){

        while (leftChild(k) < data.getSize()){
            //获取k索引的左孩子的索引
            int j = leftChild(k);

            //j + 1 < data.getSize()
            if(j + 1 < data.getSize() &&
                    //如果右孩子比左孩子大
                    data.get(j + 1).compareTo(data.get(j)) > 0){
                //最大孩子的索引赋值给j
                j = rightChild(k);
            }

            //此时data[j]是leftChild和rightChild中的最大值
            if(data.get(k).compareTo(data.get(j)) >= 0){
                //如果父亲节点大于等于左右孩子节点，跳出循环
                break;
            }

            //如果父亲节点小于左右孩子节点(中的最大值)，交换索引的值
            data.swap(k, j);

            //交换完成之后，将j赋值给K,重新进入循环
            k = j;
        }
    }

    /**
     * 取出堆中最大元素，并且替换成元素e
     * @param e
     * @return
     */
    public E replace(E e){
        //获取堆中的最大值
        E ret = findMax();
        //用新添加的元素替换最大的元素
        data.set(0, e);
        //0索引元素比左右孩子节点元素小，则交换位置，不断循环
        siftDown(0);
        return ret;
    }
}
