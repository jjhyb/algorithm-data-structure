package com.yibo.algorithm.bucketsort;

import java.util.*;

/**
 * @Author: huangyibo
 * @Date: 2022/3/14 15:30
 * @Description: 桶排序
 */

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {220, 134, 0, 153, 2, 1314, 87, 2022, -8, -99};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        //建立桶，个数和待排序数组长度一样
        int len = arr.length;

        List<Integer>[] bucket = new LinkedList[len];
        // 找出待排序数组arr中的最大值
        int max = Arrays.stream(arr).max().getAsInt();

        //根据每个元素的值, 分配到对应范围的桶中
        for (int i = 0; i < arr.length; i++) {
            int index = toBucketIndex(arr[i], max, len);
            // 没有桶才建立桶(延时)
            if (bucket[index] == null) {
                bucket[index] = new LinkedList<>();
            }
            // 有桶直接使用
            bucket[index].add(arr[i]);
        }

        // 对每个非空的桶排序，排序后顺便存入临时的List，则list中已经有序）
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                temp.addAll(bucket[i]);
            }
        }

        // 将temp中的数据写入原数组
        for (int i = 0; i < len; i++) {
            arr[i] = temp.get(i);
        }
    }

    /**
     * 映射函数，将值转换为应存放到的桶数组的索引
     * @param value
     * @param maxValue
     * @param length
     * @return
     */
    private static int toBucketIndex(int value, int maxValue, int length) {
        return (value * length) / (maxValue + 1);
    }
}
