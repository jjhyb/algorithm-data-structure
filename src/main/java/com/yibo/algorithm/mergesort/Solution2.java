package com.yibo.algorithm.mergesort;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/1/18 23:38
 * @Description: 数组中的逆序对 采用归并排序算法求解, 时间复杂度读为O(n㏒n)
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数
 */
public class Solution2 {

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return sort(nums,0,nums.length-1,temp);
    }

    private int sort(int[] arr, int left, int right, int[] temp){
        //如果left >= right则停止分解
        if(left >= right){
            return 0;
        }
        int res = 0;

        //对 left和 right 进行对半分解
        int mid = (left + right) >>> 1;

        //对left和mid区间进行二分分解
        res += sort(arr, left, mid, temp);

        //对mid + 1和right区间进行二分分解
        res += sort(arr,mid + 1, right, temp);

        if(arr[mid] > arr[mid + 1]) {
            //归并并排序 arr[left, mid] 和 arr[mid+1, right]两个区间
            res += merge(arr, left, mid, right, temp);
        }
        return res;
    }

    private int merge(int[] arr, int left, int mid, int right, int[] temp){
        //将arr数组从left位置开始拷贝到temp数组的left位置开始
        //拷贝right - left + 1个元素，(前闭后开，所以要 + 1)
        //因为没有额外的内存开辟，性能优化很高
        System.arraycopy(arr, left, temp, left,right - left + 1);

        int i = left;
        int j = mid + 1;
        int res = 0;

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
            }else if(temp[i] <= temp[j]) {
                //如果temp[i]小于等于temp[j]，直接归并temp[i]的值到arr
                arr[k] = temp[i];
                i ++;
            }else {
                //如果temp[i]大于temp[j]，直接归并temp[j]的值到arr
                res += mid - i + 1;
                arr[k] = temp[j];
                j++;
            }
        }
        return res;
    }
}
