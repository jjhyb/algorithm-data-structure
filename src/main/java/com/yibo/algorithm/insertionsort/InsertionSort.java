package com.yibo.algorithm.insertionsort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2021/12/24 0:30
 * @Description:
 */
public class InsertionSort {

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

    public static <E extends Comparable<E>> void insertionSort2(E[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j - 1]) < 0){
                    //将arr[j]插到合适的位置
                    swap(arr, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
