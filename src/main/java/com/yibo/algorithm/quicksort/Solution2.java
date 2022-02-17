package com.yibo.algorithm.quicksort;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2022/1/23 1:45
 * @Description:
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Solution2 {

    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        sort(nums,0, nums.length - 1, random);
        return nums[nums.length - k];
    }

    private void sort(int[] arr, int left, int right, Random random){
        if(left >= right){
            return;
        }

        int pv = random.nextInt(right - left + 1) + left;

        swap(arr, left, pv);

        int lt = left;
        int i = left + 1;
        int gt = right + 1;

        while (i < gt){
            if(arr[i] < arr[left]){
                lt ++;
                swap(arr, i, lt);
                i++;
            }else if(arr[i] > arr[left]){
                gt --;
                swap(arr, i, gt);
            }else{
                i++;
            }
        }
        swap(arr, left, lt);

        sort(arr, left, lt - 1,random);

        sort(arr, gt, right, random);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
