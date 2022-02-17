package com.yibo.algorithm.mergesort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/1/16 16:49
 * @Description: 归并排序(从上往下) 内存优化
 */
public class MergeSort3 {

    public static <E extends Comparable<E>> void mergeSort(E[] arr){
        if(arr == null){
            return;
        }
        //使用公共的临时数组辅助进行数组顺序的归并 merge()方法专用
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr,0,arr.length-1,temp);
    }

    /**
     * 对数组进行分解，排序并归并
     * @param arr 待排序的数组
     * @param left 数组的起始地址
     * @param right 数组的结束地址
     * @param temp merge()方法专用, 公共的临时空间，辅助进行数组顺序的归并
     * @param <E> 泛型
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right, E[] temp){
        //如果left >= right则停止分解
        if(left >= right){
            return;
        }

        //对 left和 right 进行对半分解
        int mid = (left + right) >>> 1;

        //对left和mid区间进行二分分解
        sort(arr, left, mid, temp);

        //对mid + 1和right区间进行二分分解
        sort(arr,mid + 1, right, temp);

        if(arr[mid].compareTo(arr[mid + 1]) > 0) {
            //归并并排序 arr[left, mid] 和 arr[mid+1, right]两个区间
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并
     * 合并两个区间 arr[left, mid] 和arr[mid+1, right]
     * @param arr 包含两个有序区间的数组
     * @param left 第1个有序区间的起始地址
     * @param mid 第1个有序区间的结束地址。也是第2个有序区间的起始地址
     * @param right 第2个有序区间的结束地址
     * @param temp 公共的临时空间，辅助进行数组顺序的归并
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int left, int mid, int right, E[] temp){
        //将arr数组从left位置开始拷贝到temp数组的left位置开始
        //拷贝right - left + 1个元素，(前闭后开，所以要 + 1)
        //因为没有额外的内存开辟，性能优化很高
        System.arraycopy(arr, left, temp, left,right - left + 1);

        int i = left;
        int j = mid + 1;

        //每轮循环对arr[k]进行赋值
        for(int k = left; k <= right; k++){
            //主要就是比较temp[i]和temp[j]的值大小，进行调整
            if(i > mid){
                //如果i大于mid，直接归并temp[j,right]区间的元素到arr
                arr[k] = temp[j];
                j++;
            }else if(j > right){
                //如果j大于right，直接归并temp[i,mid]区间的元素到arr
                arr[k] = temp[i];
                i ++;
            }else if(temp[i].compareTo(temp[j]) <= 0) {
                //如果temp[i]小于等于temp[j]，直接归并temp[i]的值到arr
                arr[k] = temp[i];
                i ++;
            }else {
                //如果temp[i]大于temp[j]，直接归并temp[j]的值到arr
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
