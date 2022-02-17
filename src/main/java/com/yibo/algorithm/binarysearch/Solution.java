package com.yibo.algorithm.binarysearch;

/**
 * @Author: huangyibo
 * @Date: 2022/1/24 0:27
 * @Description:
 */
public class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) >>> 1;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
