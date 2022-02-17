package com.yibo.algorithm.mergesort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/1/16 16:49
 * @Description: 归并排序(从下往上)
 */
public class MergeSort5 {

    public static <E extends Comparable<E>> void mergeSort(E[] arr){
        if(arr == null){
            return;
        }

        //使用公共的临时数组辅助进行数组顺序的归并 merge()方法专用
        E[] temp = Arrays.copyOf(arr, arr.length);

        //从1开始，按2的倍数进行分解
        for (int sz = 1; sz < arr.length; sz *= 2) {

            //内层循环 从0出发，每一轮按两个sz区间的增长遍历合并，即起始位置为i
            //合并 [i, i + sz - 1] 和 [i + sz, Math.min(i + sz + sz - 1, arr.length - 1)] 区间的元素
            for (int i = 0; i + sz < arr.length; i += sz + sz){
                //i += sz + sz 即i按sz的2倍递增
                //i + sz < arr.length 说明后面的区间还有元素,后面的区间有元素，则就要和前面的区间进行合并
                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0){
                    //注意 i + sz + sz - 1有可能会越界，所以使用Math.min(i + sz + sz - 1, arr.length - 1)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, arr.length - 1) ,temp);
                }
            }
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
     * @param <E> 泛型
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
