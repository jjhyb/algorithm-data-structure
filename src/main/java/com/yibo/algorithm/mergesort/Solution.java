package com.yibo.algorithm.mergesort;

/**
 * @Author: huangyibo
 * @Date: 2022/1/18 23:38
 * @Description: 数组中的逆序对 采用双层for循环求解，时间复杂度读为O(n²)
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数
 */
public class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    count ++;
                }
            }
        }
        return count;
    }
}
