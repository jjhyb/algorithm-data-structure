package com.yibo.algorithm.shellsort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/20 15:35
 * @Description: 希尔排序 优化版 针对有序序列在插入时采用移动法
 */

public class ShellSort4 {

    public static <E extends Comparable<E>> void shellSort(E[] arr){
        //增量gap，并逐步缩小增量, 每一轮缩小为原来的2分之一
        //gap的取值可以变化，可以 gap /= 3
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            //每个子数组元素为arr[start, start + gap, start + 2gap, start + 3gap ......]
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap; i < arr.length; i++){
                int j = i;
                //当前待插入元素
                E temp = arr[j];

                //如果待插入元素和当前子数组的前一个元素比较，小于前一个元素，并且索引合法
                while(j - gap >= 0 && temp.compareTo(arr[j - gap]) < 0){
                    //移动法
                    arr[j] = arr[j-gap];
                    //将子数组更前的索引赋值给循环变量
                    j -= gap;
                }
                //待插入的元素插入到应该的位置
                arr[j] = temp;
            }
        }
    }
}
