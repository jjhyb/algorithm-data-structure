package com.yibo.algorithm.selectionsort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2021/12/23 0:24
 * @Description:
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] arr = {5, 9, 7, 4, 1, 3, 2, 8};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <E extends Comparable<E>> void selectionSort(E[] arr){
        //i代表每轮选择最小元素要交换到的目标索引
        for (int i = 0; i < arr.length - 1; i++) {
            //代表最小元素的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex].compareTo(arr[j]) > 0){
                    minIndex = j;
                }
            }
            //在每一轮最后交换元素
            if(minIndex != i){
                swap(arr, i, minIndex);
            }
        }
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
