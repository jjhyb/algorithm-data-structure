package com.yibo.algorithm.insertionsort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2021/12/24 0:30
 * @Description:
 */
public class InsertionSort2 {

    public static void main(String[] args) {
        Integer[] arr = {5, 9, 7, 4, 1, 3, 2, 8};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <E extends Comparable<E>> void insertionSort(E[] arr){
        //i代表待插入元素的索引
        for (int i = 1; i < arr.length; i++) {
            //代表待插入的元素值
            E temp = arr[i];
            //j 代表已排序区域的元素索引
            int j = i - 1;
            while (j >= 0){
                if(temp.compareTo(arr[j]) < 0){
                    arr[j + 1] = arr[j];
                }else{
                    //退出循环，减少比较次数
                    break;
                }
                j--;
            }
            //每轮循环后, 将待排序元素插入数组中
            arr[j + 1] = temp;
        }
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
