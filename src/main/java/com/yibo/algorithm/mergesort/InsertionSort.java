package com.yibo.algorithm.mergesort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2021/12/24 0:30
 * @Description: 插入排序(归并排序的优化使用版本)
 */
public class InsertionSort {

    /**
     * 对数组特定的区间进行排序，归并排序的优化使用版本
     * @param arr 待排序的数组
     * @param left 待排序的数组的起始位置
     * @param right 待排序数组的结束位置
     * @param <E> 泛型
     */
    public static <E extends Comparable<E>> void insertionSort(E[] arr,int left, int right){
        //i代表待插入元素的索引
        for (int i = left; i <= right; i++) {
            //代表待插入的元素值
            E temp = arr[i];
            //j 代表已排序区域的元素索引
            int j;
            for (j = i; j > 0; j--) {
                if(temp.compareTo(arr[j - 1]) < 0){
                    //将arr[j]插到合适的位置
                    arr[j] = arr[j - 1];
                }else {
                    //退出循环，减少比较次数
                    break;
                }
            }
            arr[j] = temp;
        }
    }
}
