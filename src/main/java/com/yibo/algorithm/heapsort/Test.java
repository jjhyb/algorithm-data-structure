package com.yibo.algorithm.heapsort;

import com.yibo.algorithm.ArrayGenerator;
import com.yibo.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 0:41
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int num = 1000000;
        Integer[] data = ArrayGenerator.generatorRandomArray(num,num);
        Integer[] data2 = Arrays.copyOf(data, data.length);
        Integer[] data3 = Arrays.copyOf(data, data.length);
        Integer[] data4 = Arrays.copyOf(data, data.length);
        SortingHelper.sortTest("HeapSort",data);
        SortingHelper.sortTest("HeapSort2",data2);

        SortingHelper.sortTest("QuickSort3",data3);
        SortingHelper.sortTest("QuickSort5",data4);
    }
}
