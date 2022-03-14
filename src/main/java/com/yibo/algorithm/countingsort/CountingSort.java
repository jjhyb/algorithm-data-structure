package com.yibo.algorithm.countingsort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/3/13 15:48
 * @Description: 计数排序 正整数，且非稳定排序版本, 浪费内存验证
 */

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 8, 9, 7, 2, 5};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        // 找出数组arr中的最大值
        int max = Arrays.stream(arr).max().getAsInt();
        // 初始化计数数组count, 存储每个整数出现的次数
        int[] count = new int[max + 1];
        // 对计数数组各元素赋值
        for (int num : arr) {
            count[num]++;
        }

        // 创建结果数组的起始索引
        int index = 0;
        // 遍历计数数组，将计数数组的索引填充到原数组中
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
}
