package com.yibo.algorithm.mergesort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/1/16 16:49
 * @Description: 归并排序(从上往下) 采用插入排序优化
 */
public class MergeSort2 {

    public static <E extends Comparable<E>> void mergeSort(E[] arr){
        if(arr == null){
            return;
        }

        sort(arr,0,arr.length-1);
    }

    /**
     * 对数组进行分解，排序并归并
     * @param arr 待排序的数组
     * @param left 数组的起始地址
     * @param right 数组的结束地址
     * @param <E> 泛型
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right){
        //如果待分解排序归并的区间小于特定的值，
        //停止分解，采用插入排序优化
        //因为待分解排序归并的区间比较小，使用归并排序反而更耗时
        //不同的计算机硬件配置，效果不一样，可能优化后性能更低
        if((right - left) <= 15){
            InsertionSort.insertionSort(arr, left, right);
            return;
        }

        //对 left和 right 进行对半分解
        int mid = (left + right) >>> 1;

        //对left和mid区间进行二分分解
        sort(arr, left, mid);

        //对mid + 1和right区间进行二分分解
        sort(arr,mid + 1, right);

        if(arr[mid].compareTo(arr[mid + 1]) > 0) {
            //归并并排序 arr[left, mid] 和 arr[mid+1, right]两个区间
            merge(arr, left, mid, right);
        }
    }

    /**
     * 归并
     * 合并两个区间 arr[left, mid] 和arr[mid+1, right]
     * @param arr 包含两个有序区间的数组
     * @param left 第1个有序区间的起始地址
     * @param mid 第1个有序区间的结束地址。也是第2个有序区间的起始地址
     * @param right  第2个有序区间的结束地址
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int left, int mid, int right){
        //使用临时数组辅助进行数组顺序的归并
        E[] temp = Arrays.copyOf(arr, arr.length);
        int i = left;
        int j = mid + 1;

        //每轮循环对arr[k]进行赋值
        for(int k = left; k <= right; k++){
            //主要就是比较temp[i]和temp[j]的值大小，进行调整
            if(i > mid){
                //如果i大于mid，直接归并temp[j,right]区间的元素到arr
                arr[k] = temp[j - left];
                j++;
            }else if(j > right){
                //如果j大于right，直接归并temp[i,mid]区间的元素到arr
                arr[k] = temp[i - left];
                i ++;
            }else if(temp[i - left].compareTo(temp[j - left]) <= 0) {
                //如果temp[i]小于等于temp[j]，直接归并temp[i]的值到arr
                arr[k] = temp[i - left];
                i ++;
            }else {
                //如果temp[i]大于temp[j]，直接归并temp[j]的值到arr
                arr[k] = temp[j - left];
                j++;
            }
        }
    }
}
