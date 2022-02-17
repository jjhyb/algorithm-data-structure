package com.yibo.algorithm.quicksort;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2022/1/22 0:09
 * @Description: 单边快速排序：选择排序区间最左边元素作为基准点元素
 */
public class QuickSort {

    public static <E extends Comparable<E>> void quickSort(E[] arr){
        Random random = new Random();
        sort(arr,0, arr.length - 1, random);
    }

    /**
     * 以基准点元素索引，对数组进行递归调用
     * @param arr 待排序数组
     * @param left 待排序数组的左边界
     * @param right 待排序数组的右边界
     * @param random 随机数生成 partition方法使用
     * @param <E> 泛型
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right, Random random){
        //当指定区间范围内元素值小于等于1的时候, 停止递归调用
        if(left >= right){
            return;
        }
        //基准点的正确索引值
        int pv = partition(arr, left, right, random);

        //左边分区的范围确定
        sort(arr,left,pv - 1, random);

        //右边分区的范围确定
        sort(arr,pv + 1, right, random);
    }

    /**
     * 以左边元素为基准点元素进行分区排序
     * 生成[left, right]区间之间的随机数索引pv
     * 将left与pv之间的元素交换位置
     * 防止在有序数组前提下，
     * 快速排序使用最左元素为基准点元素排序，导致排序性能下降的问题
     * @param arr 排序数组
     * @param left 左边界索引
     * @param right 右边界索引
     * @param random 随机数生成
     * @param <E> 泛型
     * @return 返回值代表基准点元素所在的正确索引，用以确定下轮分区的边界
     */
    private static <E extends Comparable<E>> int partition(E[] arr, int left, int right, Random random){
        //生成[left, right]区间之间的随机数索引
        //区间范围的计算方式是: （(最大值 - 最小值 + 1) + 最小值）
        int pv = random.nextInt(right - left + 1) + left;
        // 这里交换位置的原因在于，在有序数组前提下，
        // 快速排序使用最左元素为基准点元素排序，导致排序性能下降
        swap(arr, left, pv);

        //定义小于基准点元素的边界索引j, 区间即为arr[left+1, j]
        int j = left;
        //定义当前访问的元素索引i
        //大于基准点元素数组区间即为arr[j+1, i]
        for (int i = left + 1; i <= right; i++) {
            //以左边元素为基准点元素进行分区排序
            if(arr[i].compareTo(arr[left]) < 0){
                //小于基准点元素的边界索引j先自增
                j++;
                //然后交换j和i的元素
                swap(arr, i, j);
            }
        }
        //一轮循环之后，基准点元素和小于基准点元素边界值元素交换
        if(left != j){
            //基准点交换
            swap(arr, left, j);
        }
        //返回值代表基准点元素所在的正确索引，用以确定下轮分区的边界
        return j;
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
