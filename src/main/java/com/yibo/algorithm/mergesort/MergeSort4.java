package com.yibo.algorithm.mergesort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/1/16 16:49
 * @Description: 归并排序(从下往上)
 */
public class MergeSort4 {

    public static <E extends Comparable<E>> void mergeSort(E[] arr){
        if(arr == null){
            return;
        }

        //从1开始，按2的倍数进行分解
        for (int i = 1; i < arr.length; i *= 2) {
            mergeGroups(arr, arr.length, i);
        }
    }

    /**
     * 对数组arr做若干次合并：数组a的总长度为len，将它分为若干个长度为gap的子数组
     * 将"每2个相邻的子数组" 进行合并排序。
     * @param arr 待排序的数组
     * @param len 数组的长度
     * @param gap 子数组的长度
     * @param <E> 泛型
     */
    private static <E extends Comparable<E>> void mergeGroups(E[] arr, int len, int gap){
        int i;
        int twoLen = 2 * gap;    // 两个相邻的子数组的长度

        // 将"每2个相邻的子数组" 进行合并排序。
        for(i = 0; i + twoLen - 1 < len; i += twoLen){
            merge(arr, i, i + gap - 1, i + twoLen - 1);
        }

        // 若 i + gap-1 < len-1，则剩余一个子数组没有配对。
        // 将该子数组合并到已排序的数组中。
        if (i + gap - 1 < len - 1){
            merge(arr, i, i + gap - 1, len - 1);
        }
    }

    /**
     * 归并
     * 合并两个区间 arr[left, mid] 和arr[mid+1, right]
     * @param arr 包含两个有序区间的数组
     * @param left 第1个有序区间的起始地址
     * @param mid 第1个有序区间的结束地址。也是第2个有序区间的起始地址
     * @param right  第2个有序区间的结束地址
     * @param <E> 泛型
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
