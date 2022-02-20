package com.yibo.algorithm.shellsort;

import com.yibo.algorithm.ArrayGenerator;
import com.yibo.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/2/20 16:09
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int num = 1000000;
        Integer[] data = ArrayGenerator.generatorRandomArray(num,num);
        Integer[] data2 = Arrays.copyOf(data, data.length);
        Integer[] data3 = Arrays.copyOf(data, data.length);
        Integer[] data4 = Arrays.copyOf(data, data.length);
        Integer[] data5 = Arrays.copyOf(data, data.length);
        Integer[] data6 = Arrays.copyOf(data, data.length);

        SortingHelper.sortTest("ShellSort",data);
        SortingHelper.sortTest("ShellSort2",data2);
        SortingHelper.sortTest("ShellSort3",data3);
        SortingHelper.sortTest("ShellSort4",data4);
        SortingHelper.sortTest("MergeSort3",data5);
        SortingHelper.sortTest("QuickSort3",data6);


    }
}
