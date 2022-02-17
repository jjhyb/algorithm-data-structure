package com.yibo.algorithm.selectionsort;

import com.yibo.algorithm.ArrayGenerator;
import com.yibo.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2021/12/21 21:46
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Student[] students = {new Student("张无忌",100),
                new Student("令狐冲", 99),
                new Student("段誉",87),
                new Student("叶孤城",98)};
        SelectionSort.selectionSort(students);
        System.out.println(Arrays.toString(students));

        int num = 10000;
        Integer[] data = ArrayGenerator.generatorRandomArray(num,num);
        SortingHelper.sortTest("SelectionSort",data);
    }
}
