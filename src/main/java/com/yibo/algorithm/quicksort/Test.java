package com.yibo.algorithm.quicksort;

import com.yibo.algorithm.ArrayGenerator;
import com.yibo.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/1/16 19:02
 * @Description: 快速排序——双边循环快排(并不完全等价于hoare霍尔分区方案)
 * 1、选择最左元素作为基准点元素
 * 2、j指针负责从右向左找比基准点小的元素, i指针负责从左向右找比基准点大的元素, 一旦找到二者交换, 直到i、j相交
 * 3、最后基准点与i(此时i与j相等)交换, i即为分区位置
 *
 * 特点:
 * 1、平均时间复杂度是O(n ㏒₂n), 最坏时间内复杂度为O(n²)
 * 2、数据量较大时，优势非常明显
 * 3、属于不稳定排序算法
 */
public class Test {

    public static void main(String[] args) {
        int num = 1000000;
        Integer[] data = ArrayGenerator.generatorRandomArray(num,num);
        Integer[] data2 = Arrays.copyOf(data, data.length);
        Integer[] data3 = Arrays.copyOf(data, data.length);
        Integer[] data4 = Arrays.copyOf(data, data.length);


        SortingHelper.sortTest("QuickSort",data);

        SortingHelper.sortTest("QuickSort3",data2);
        SortingHelper.sortTest("QuickSort4",data3);
        SortingHelper.sortTest("QuickSort5",data4);

        SortingHelper.sortTest("QuickSort",data);

        SortingHelper.sortTest("QuickSort3",data2);
        SortingHelper.sortTest("QuickSort5",data4);

        Integer[] data5 = ArrayGenerator.generatorRandomArray(num,1);
        SortingHelper.sortTest("QuickSort3",data5);
        SortingHelper.sortTest("QuickSort5",data5);
    }
}
