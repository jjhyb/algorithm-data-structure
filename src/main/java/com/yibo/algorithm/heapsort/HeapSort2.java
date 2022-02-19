package com.yibo.algorithm.heapsort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 0:42
 * @Description: 堆排序：原地排序
 * 1、先将待排序数组整理成最大堆的形状
 * 2、然后将堆的最开始索引的值即最大值和最后面的索引值交换，不断循完成排序
 * 3、每交换一轮后，将0索引元素和其左右孩子节点元素进行比较，如果比左右孩子小，则交换位置，不断循环
 */

public class HeapSort2 {

    public static <E extends Comparable<E>> void heapSort(E[] arr){
        //如果arr元素个数小于等于1，直接返回
        if(arr.length <= 1){
            return;
        }

        //从最后一个叶子节点的父节点开始进行siftDown操作,不断循环
        //(arr.length - 1) / 2 最后一个叶子节点的父节点的索引
        //for循环完成，则将数组整理成堆的形状
        for(int i = (arr.length - 1) / 2; i >= 0; i --){
            siftDown(arr, i, arr.length);
        }

        //进行排序操作，将堆的最开始索引的值即最大值和最后面的索引值交换，不断循完成排序
        for (int i = arr.length - 1; i >= 0; i--) {
            //将堆的最开始索引的值即最大值和最后面的索引值交换
            swap(arr,0, i);

            //将0索引元素比左右孩子节点元素小，则交换位置，不断循环
            //由于数组最末尾的值已经排好序，索引排好序的元素不包含在内
            siftDown(arr, 0, i);
        }
    }

    /**
     * 对arr[0, n] 所形成的最大堆中，索引k的元素，执行siftDown操作
     * k索引元素比左右孩子节点元素小，则交换位置，不断循环
     * @param arr
     * @param k
     * @param n
     * @param <E>
     */
    private static <E extends Comparable<E>> void siftDown(E[] arr, int k, int n){
        //(k * 2 + 1) 完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        while ((k * 2 + 1) < n){
            //获取k索引的左孩子的索引
            int j = k * 2 + 1;

            //j + 1 < data.getSize()
            if(j + 1 < n &&
                    //如果右孩子比左孩子大
                    arr[j + 1].compareTo(arr[j]) > 0){
                //k * 2 + 2 完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
                //最大孩子的索引赋值给j
                j = k * 2 + 2;
            }

            //此时data[j]是leftChild和rightChild中的最大值
            if(arr[k].compareTo(arr[j]) >= 0){
                //如果父亲节点大于等于左右孩子节点，跳出循环
                break;
            }

            //如果父亲节点小于左右孩子节点(中的最大值)，交换索引的值
            swap(arr, k, j);

            //交换完成之后，将j赋值给K,重新进入循环
            k = j;
        }
    }

    /**
     * 数组索引元素交换
     * @param arr
     * @param i
     * @param j
     * @param <E>
     */
    private static <E> void swap(E[] arr, int i, int j){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
