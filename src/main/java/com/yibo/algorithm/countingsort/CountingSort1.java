package com.yibo.algorithm.countingsort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/3/13 15:48
 * @Description: 计数排序, 且非稳定排序版本
 */

public class CountingSort1 {

    public static void main(String[] args) {
        int[] arr = {220, 134, 0, 153, 2, 1314, 87, 2022, -8, -99};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        // 找出数组arr中的最大值
        int max = Arrays.stream(arr).max().getAsInt();
        // 找出数组arr中的最小值
        int min = Arrays.stream(arr).min().getAsInt();

        // 初始化计数数组count, 存储每个整数出现的次数
        int[] count = new int[max - min + 1];
        // 对计数数组各元素赋值
        for (int num : arr) {
            // arr中的元素要减去最小值，再作为新索引
            count[num - min]++;
        }

        // 计数数组变形，新元素的值是前面元素累加之和的值
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        //从后往前遍历元素，将其放在有序数组中的合适位置
        // 创建结果数组
        int[] newArray = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            /*newArray[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min] --;*/

            //等效于上面两行代码
            newArray[--count[arr[i] - min]] = arr[i];
        }
        //将有序数组赋值给原数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArray[i];
        }
    }
}
