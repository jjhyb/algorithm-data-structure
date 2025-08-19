package com.yibo.datastructure.maxheap.leetcode;

import com.yibo.datastructure.maxheap.MinHeap;

/**
 * @Author: huangyibo
 * @Date: 2025/8/18 0:37
 * @Description: 数据流中的第 K 大元素
 */
public class Leetcode703 {

    private MinHeap<Integer> minHeap;
    public Leetcode703(int k, int[] nums) {
        minHeap = new MinHeap<>(k);
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(!minHeap.isFull()){
            minHeap.offer(val);
        } else {
            if(minHeap.peek().compareTo(val) < 0 ) {
                minHeap.replace(val);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Leetcode703 test = new Leetcode703(4, new int[]{4, 5, 8, 3});
        System.out.println(test.add(3));
        System.out.println(test.add(5));
        System.out.println(test.add(10));
        System.out.println(test.add(11));
        System.out.println(test.add(4));
        System.out.println(test.add(12));
    }
}
