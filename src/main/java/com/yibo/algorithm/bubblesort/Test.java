package com.yibo.algorithm.bubblesort;

import com.yibo.algorithm.ArrayGenerator;
import com.yibo.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 22:43
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int num = 10000;
        Integer[] data = ArrayGenerator.generatorRandomArray(num,num);
        Integer[] data2 = Arrays.copyOf(data, data.length);
        Integer[] data3 = Arrays.copyOf(data, data.length);
        Integer[] data4 = Arrays.copyOf(data, data.length);
        Integer[] data5 = Arrays.copyOf(data, data.length);
        SortingHelper.sortTest("BubbleSort",data);
        SortingHelper.sortTest("BubbleSort2",data2);
        SortingHelper.sortTest("BubbleSort3",data3);
        SortingHelper.sortTest("BubbleSort4",data4);
        SortingHelper.sortTest("BubbleSort5",data5);

        SortingHelper.sortTest("BubbleSort",data);
        SortingHelper.sortTest("BubbleSort2",data2);
        SortingHelper.sortTest("BubbleSort3",data3);
        SortingHelper.sortTest("BubbleSort4",data4);
        SortingHelper.sortTest("BubbleSort5",data5);
    }
}
