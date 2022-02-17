package com.yibo.algorithm.quicksort;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2022/1/22 0:09
 * @Description: 快速排序——单边循环快排(lomuto 洛穆托分区方案)
 * 1、选择最右元素作为基准点元素
 * 2、j指针负责找到比基准点小的元素, 一旦找到则与i进行交换
 * 3、i指针维护小于基准点元素的边界, 也是每次交换的目标索引
 * 4、最后基准点与i元素交换, i即为分区位置
 */
public class QuickSort2 {

    public static <E extends Comparable<E>> void quickSort(E[] arr) {
        sort(arr,0,arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {
        //当指定区间范围内元素值小于等于1的时候, 停止递归调用
        if(left >= right){
            return;
        }

        //pv 基准点的正确索引值
        int pv = partition(arr, left, right);

        //左边分区的范围确定
        sort(arr, left,pv - 1);

        //右边分区的范围确定
        sort(arr, pv + 1, right);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int left, int right) {
        //基准点元素
        E pivot = arr[right];
        int i = left;
        for (int j = i; j < right; j++) {
            if(arr[j].compareTo(pivot) < 0){
                if(i != j){
                    //i和j不相等的时候才交换元素
                    swap(arr, i, j);
                }
                i++;
            }
        }
        if(i != right){
            //一轮循环之后，基准点元素和小于基准点元素边界值交换
            swap(arr, right, i);
        }

        //返回值代表了基准点元素所在的正确索引，它确定下一轮分区的边界
        return i;
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
