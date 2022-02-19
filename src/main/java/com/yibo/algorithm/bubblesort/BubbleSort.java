package com.yibo.algorithm.bubblesort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 22:37
 * @Description: 冒泡排序 常规版
 * 文字描述(以升序为例)
 * 1、依次比较数组中相邻两个元素大小，若 arr[j] > arr[j + 1], 则交换两个元素,
 *      两两都比较一遍则称为一轮冒泡，结果是让最大的元素排到最后
 * 2、重复以上步骤, 直到整个数组有序
 */

public class BubbleSort {

    public static <E extends Comparable<E>> void bubbleSort(E[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr, j,j + 1);
                }
            }
        }
    }

    /**
     * 交换数组元素
     * @param arr
     * @param i
     * @param j
     * @param <E>
     */
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
