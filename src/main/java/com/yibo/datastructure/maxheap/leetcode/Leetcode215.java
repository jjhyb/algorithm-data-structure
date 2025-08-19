package com.yibo.datastructure.maxheap.leetcode;

import com.yibo.datastructure.maxheap.MinHeap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Author: huangyibo
 * @Date: 2025/8/17 23:49
 * @Description: 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        MinHeap<Integer> minHeap = new MinHeap<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(minHeap.peek().compareTo(nums[i]) < 0){
                minHeap.replace(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new Leetcode215().findKthLargest(nums, k));
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        int k2 = 4;
        System.out.println(new Leetcode215().findKthLargest(nums2, k2));
    }
}
