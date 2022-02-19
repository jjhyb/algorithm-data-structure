package com.yibo.datastructure.priorityqueue;

import java.util.PriorityQueue;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 18:05
 * @Description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Solution3 {

    public int findKthLargest(int[] nums, int k) {
        //java.util.PriorityQueue 默认为最小堆实现
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //现将k个元素放进优先队列中
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        //数组余下的元素和pq最大的元素进行比较
        for (int i = k; i < nums.length; i++) {
            //如果数组元素比优先队列中最小的元素大的话
            if(!pq.isEmpty() && nums[i] > pq.peek()){
                //优先队列中最小元素出队
                pq.remove();
                //将数组元素放入优先队列中
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
