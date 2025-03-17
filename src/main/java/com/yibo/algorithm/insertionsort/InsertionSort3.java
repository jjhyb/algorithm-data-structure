package com.yibo.algorithm.insertionsort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2021/12/24 0:30
 * @Description: 插入排序 递归版
 */
public class InsertionSort3 {

    public static void main(String[] args) {
        Integer[] arr = {5, 9, 7, 4, 5, 1, 3, 2, 8};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <E extends Comparable<E>> void insertionSort(E[] arr){
      insertion(arr, 1);
    }

    public static <E extends Comparable<E>> void insertion(E[] arr, int low) {
        if(low >= arr.length){
            return;
        }
        //临时变量, 待插入的值
        E temp = arr[low];
        //已排序区域的指针
        int i = low -1;
        //循环寻找插入位置
        while (i >= 0 && arr[i].compareTo(temp) > 0) {
            //交换位置
            arr[i + 1] = arr[i];
            i --;
        }
        //如果插入的索引不等于待排序的索引
        if(i + 1 != low) {
            //插入操作
            arr[i + 1] = temp;
        }
        //递归调用
        insertion(arr, low + 1);
    }
}
