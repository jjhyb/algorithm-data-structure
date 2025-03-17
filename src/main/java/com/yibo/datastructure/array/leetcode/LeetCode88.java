package com.yibo.datastructure.array.leetcode;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2024/12/22 17:19
 * @Description: 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 */
public class LeetCode88 {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};

        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int mIndex = m - 1;
        int nIndex = n - 1;
        while (mIndex >= 0 && nIndex >= 0) {
            if(nums1[mIndex] > nums2[nIndex]){
                nums1[k] = nums1[mIndex];
                mIndex--;
            }else {
                nums1[k] = nums2[nIndex];
                nIndex--;
            }
            k--;
        }
        if(nIndex >= 0) {
            for (int i = nIndex; i >= 0; i--) {
                nums1[k] = nums2[i];
                k--;
            }
        }
    }

    /**
     * 对一个数组内部的两个有序区间的数据进行排序 递归方式
     * 采用类似归并排序的方式进行排序
     * @param a1    原始数组
     * @param i     第一个有序区间的起点
     * @param iEnd  第一个有序区间的结尾
     * @param j     第二个有序区间的起点
     * @param jEnd  第二个有序区间的结尾
     * @param a2    结果数组
     * @param k
     */
    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2, int k){
        if(i > iEnd && jEnd > j) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        }
        if(j > jEnd && iEnd > i) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }
        if(a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i+1, iEnd, j, jEnd, a2, k+1);
        }else {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j+1, jEnd, a2, k+1);
        }
    }
}
