package com.yibo.algorithm.mergesort;

import com.yibo.algorithm.ArrayGenerator;
import com.yibo.algorithm.SortingHelper;
import com.yibo.algorithm.selectionsort.SelectionSort;
import com.yibo.algorithm.selectionsort.Student;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/1/16 19:02
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int num = 100000;
        Integer[] data = ArrayGenerator.generatorRandomArray(num,num);
        Integer[] data2 = Arrays.copyOf(data, data.length);
        Integer[] data3 = Arrays.copyOf(data, data.length);
        Integer[] data4 = Arrays.copyOf(data, data.length);
        Integer[] data5 = Arrays.copyOf(data, data.length);
        SortingHelper.sortTest("MergeSort",data);

        SortingHelper.sortTest("MergeSort2",data2);

        SortingHelper.sortTest("MergeSort3",data3);

        SortingHelper.sortTest("MergeSort4",data4);

        SortingHelper.sortTest("MergeSort5",data5);
    }
}
