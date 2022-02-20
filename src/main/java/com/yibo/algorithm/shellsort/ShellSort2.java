package com.yibo.algorithm.shellsort;

/**
 * @Author: huangyibo
 * @Date: 2022/2/20 15:35
 * @Description: 希尔排序 优化版，省略内层一次for循环
 */

public class ShellSort2 {

    public static <E extends Comparable<E>> void shellSort(E[] arr){
        //最开始希尔排序的元素间隔，gap增量，并逐步缩小增量
        int gap = arr.length / 2;
        //外层循环条件
        while (gap >= 1){
            //即每个子数组元素为arr[start, start + gap, start + 2gap, start + 3gap ......]
            //即对 arr[gap,n)进行插入排序
            for (int i = gap; i < arr.length; i ++) {
                //当前待插入的元素
                E t = arr[i];
                int j;
                //从当前元素开始，和当前子数组的前一个元素比较，小于前一个元素，则前一个元素挪到后面
                //不断循环，子数组以gap为间隙
                for(j = i; j - gap >= 0 && t.compareTo(arr[j - gap]) < 0; j -= gap){
                    arr[j] = arr[j - gap];
                }
                //待插入的元素插入到应该的位置
                arr[j] = t;
            }

            //每一轮循环之后，
            // gap增量逐步缩小，缩小为原来的2分之一，小于1则停止循环
            gap /= 2;
        }
    }
}
