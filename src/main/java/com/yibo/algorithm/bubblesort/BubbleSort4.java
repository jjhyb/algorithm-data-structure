package com.yibo.algorithm.bubblesort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 22:37
 * @Description: 冒泡排序 优化版3(外层for无限循环写法)
 * 每轮冒泡时，最后一次交换索引可以作为下一轮冒泡的比较次数，
 * 如果这个值小于等于0，表示整个数组有序，直接退出外层循环即可
 *
 * 有利于有序数组排序，完全有序数组直接变为O(n)
 */

public class BubbleSort4 {

    public static <E extends Comparable<E>> void bubbleSort(E[] arr){
        //循环比较次数
        int cycles = arr.length - 1;

        for ( ; ; ) {
            //最后一次发生元素交换的索引位置
            int lastSwappedIndex = 0;
            for (int j = 0; j < cycles; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr, j,j + 1);
                    lastSwappedIndex = j;
                }
            }
            //最后一次元素交换位置的索引为下一轮循环的最大次数
            cycles = lastSwappedIndex;

            //循环比较次数小于等于0，则证明数组有序
            if(cycles <= 0){
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
