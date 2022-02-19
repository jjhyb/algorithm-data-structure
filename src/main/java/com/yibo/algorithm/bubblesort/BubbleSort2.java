package com.yibo.algorithm.bubblesort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 22:37
 * @Description: 冒泡排序 优化版1
 * 用boolean变量isSwapped记录是否发生位置交换，
 * 没有发生元素交换，则证明数组有序，直接跳出循环
 *
 * 有利于有序数组排序，完全有序数组直接变为O(n)
 */

public class BubbleSort2 {

    public static <E extends Comparable<E>> void bubbleSort(E[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            //是否发生了交换
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr, j,j + 1);
                    isSwapped = true;
                }
            }

            //没有发生元素交换，则证明数组有序
            if(!isSwapped){
                break;
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
