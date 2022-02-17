package com.yibo.algorithm.quicksort;

/**
 * @Author: huangyibo
 * @Date: 2022/1/22 0:09
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
public class QuickSort4 {

    public static <E extends Comparable<E>> void quickSort(E[] arr){
        sort(arr,0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {
        //当指定区间范围内元素值小于等于1的时候, 停止递归调用
        if(left >= right){
            return;
        }

        //pv 基准点的正确索引值
        int pv = partition(arr, left, right);

        //左边分区的范围确定
        sort(arr, left,pv - 1);

        //右边分区的范围确定
        sort(arr, pv + 1, right);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int left, int right) {
        //基准点元素
        E pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j){
            //j指针负责从右向左找比基准点小的元素, 必须先从右向左找，先执行j指针
            while(i < j && arr[j].compareTo(pivot) > 0){
                j--;
            }
            //i指针负责从左向右找比基准点大的元素
            while(i < j && arr[i].compareTo(pivot) <= 0){
                i++;
            }

            if(i != j){
                //i和j不相等的时候才交换元素
                swap(arr, i, j);
            }
        }
        //一轮循环之后, i指针和j指针相交, 基准点元素和j指针(i、j指针相等)元素交换
        if(j != left){
            swap(arr, left, j);
        }

        //返回值代表了基准点元素所在的正确索引，它确定下一轮分区的边界
        return j;
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
