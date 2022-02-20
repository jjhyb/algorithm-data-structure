package com.yibo.algorithm.shellsort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/20 15:35
 * @Description: 希尔排序 优化版 针对有序序列在插入时采用交换法
 */

public class ShellSort3 {

    public static <E extends Comparable<E>> void shellSort(E[] arr){
        //增量gap，并逐步缩小增量, 每一轮缩小为原来的2分之一
        //gap的取值可以变化，可以 gap /= 3
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap; i < arr.length; i++){
                int j = i;
                while(j - gap >= 0 && arr[j].compareTo(arr[j - gap]) < 0){
                    //插入排序采用交换法
                    swap(arr,j,j-gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 交换数组元素
     * @param arr
     * @param i
     * @param j
     * @param <E>
     */
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
