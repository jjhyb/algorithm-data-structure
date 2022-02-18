package com.yibo.algorithm.heapsort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/18 21:42
 * @Description: 堆排序：非原地排序
 */
public class HeapSort {

    public static <E extends Comparable<E>> void heapSort(E[] arr){
        //建立一个最大堆
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : arr) {
            //将数组元素放入最大堆
            maxHeap.add(e);
        }

        //循环遍历，取出最大堆的最大元素倒序放入数组中，完成堆排序
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}
