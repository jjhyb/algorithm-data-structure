package com.yibo.algorithm.bubblesort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 22:37
 * @Description: 冒泡排序 优化版2
 * 每轮冒泡时，最后一次交换索引可以作为下一轮冒泡的比较次数，
 * 如果这个值小于等于0，表示整个数组有序，直接退出外层循环即可
 *
 * 有利于有序数组排序，完全有序数组直接变为O(n)
 */

public class BubbleSort3 {

    public static <E extends Comparable<E>> void bubbleSort(E[] arr){
        for (int i = 0; i < arr.length - 1; ) {
            //最后一次发生元素交换的索引位置
            int lastSwappedIndex = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr, j,j + 1);
                    lastSwappedIndex = j + 1;
                }
            }

            //外层循环遍历赋值,
            // 如果是有序数组的话，i = arr.length - 1 则直接终止了外层循环
            i = arr.length - 1 - lastSwappedIndex;
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
