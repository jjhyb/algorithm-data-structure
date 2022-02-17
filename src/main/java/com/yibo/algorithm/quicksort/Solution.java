package com.yibo.algorithm.quicksort;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2022/1/23 1:27
 * @Description:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 */
public class Solution {

    public void sortColors(int[] nums) {
        Random random = new Random();
        sort(nums,0, nums.length - 1, random);
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
        sort(arr, gt, right,random);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
