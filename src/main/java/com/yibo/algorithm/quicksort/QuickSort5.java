package com.yibo.algorithm.quicksort;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2022/1/22 0:09
 * @Description: 三路快速排序
 */
public class QuickSort5 {

    public static <E extends Comparable<E>> void quickSort(E[] arr){
        Random random = new Random();
        sort(arr,0, arr.length - 1, random);
    }

    /**
     * 以基准点元素索引，对数组进行递归调用
     * 三平均划分法快排：以最左元素、最右元素、最中间元素的中位数为枢轴
     * @param arr 待排序数组
     * @param left 待排序数组的左边界
     * @param right 待排序数组的右边界
     * @param random 随机数生成 partition方法使用
     * @param <E> 泛型
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right, Random random){
        //当指定区间范围内元素值小于等于1的时候, 停止递归调用
        if(left >= right){
            return;
        }
        //生成[left, right]区间之间的随机数索引
        //区间范围的计算方式是: （(最大值 - 最小值 + 1) + 最小值）
        int pv = random.nextInt(right - left + 1) + left;
        // 这里交换位置的原因在于，在有序数组前提下，
        // 快速排序使用最左元素为基准点元素排序，导致排序性能下降
        swap(arr, left, pv);

        //arr[left + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, right] < v
        //定义变量lt, arr[left + 1, lt]区间为小于基准点元素的值
        int lt = left;

        //定义变量i, arr[lt + 1, i - 1]区间为等于基准点元素的值
        int i = left + 1;

        //定义变量gt, arr[gt, right]区间为大于基准点元素的值
        int gt = right + 1;

        //i < gt表示有元素可以遍历比较
        while (i < gt){
            //arr[left + 1, lt]区间, 小于基准点元素的值区间新增元素
            if (arr[i].compareTo(arr[left]) < 0){
                lt++;
                swap(arr, i, lt);
                i++;
            }else if (arr[i].compareTo(arr[left]) > 0){
                //arr[gt, right]区间, 大于基准点元素的值区间新增元素
                gt--;
                swap(arr, i, gt);
                //注意这里i不++, 因为i的值从数组的gt位置交换而来，gt的值尚未进行比较
            }else{
                //arr[lt + 1, i - 1]区间为等于基准点元素的值,不用交换位置，i++即可
                i++;
            }
        }
        //循环完一轮后，将基准点元素的值归入等于基准点元素值的区间
        swap(arr, left, lt);
        //循环完一轮后现在的区间值范围
        //arr[left, lt - 1] < v, arr[lt, gt - 1] == v, arr[gt, right] < v

        //左边分区的范围确定
        sort(arr,left,lt - 1, random);

        //右边分区的范围确定
        sort(arr,gt, right, random);
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
