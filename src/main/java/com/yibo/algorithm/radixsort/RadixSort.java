package com.yibo.algorithm.radixsort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/3/14 12:48
 * @Description: 基数排序
 */

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {220, 134, 0, 153, 2, 1314, 87, 2022};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // 找出数组arr中的最大值
        int max = Arrays.stream(arr).max().getAsInt();

        //基于计算排序对元素的每个位进行排序
        //最多循环最大元素的位数，位数不够的用0进行排序
        for (int i = 10; i < max; i *= 10) {
            countSort(arr, i);
        }
    }

    /**
     * 基于计算排序对元素的每个位进行排序
     * 最多循环最大元素的位数，位数不够的用0进行排序
     * @param arr
     * @param divider
     */
    private static void countSort(int[] arr, int divider) {
        // 基数（数位的取值范围为[0,9]）
        int radix = 10;

        // 初始化计数数组count, 存储每个数位出现的次数
        int[] count = new int[radix];
        // 对计数数组各元素赋值
        for (int num : arr) {
            // arr中的元素要减去最小值，再作为新索引
            count[num / divider % radix]++;
        }

        // 计数数组变形，新元素的值是前面元素累加之和的值
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        //从后往前遍历元素，将其放在有序数组中的合适位置
        // 创建结果数组
        int[] newArray = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            newArray[--count[arr[i] / divider % radix]] = arr[i];
        }
        //将有序数组赋值给原数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArray[i];
        }
    }
}
