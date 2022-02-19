package com.yibo.datastructure.priorityqueue;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 18:05
 * @Description: 在N个元素中选出最小的K个元素
 */

public class Solution {

    public int[] getLeastNumbers(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //现将k个元素放进优先队列中
        for (int i = 0; i < k; i++) {
            pq.enqueue(arr[i]);
        }

        //数组余下的元素和pq最大的元素进行比较
        for (int i = k; i < arr.length; i++) {
            //如果数组元素比优先队列中最大的元素小的话
            if(!pq.isEmpty() && arr[i] < pq.getFront()){
                //优先队列中最大元素出队
                pq.dequeue();
                //将数组元素放入优先队列中
                pq.enqueue(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.dequeue();
        }
        return result;
    }
}
