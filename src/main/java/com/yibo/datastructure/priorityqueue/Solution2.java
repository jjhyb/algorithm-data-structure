package com.yibo.datastructure.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: huangyibo
 * @Date: 2022/2/19 18:05
 * @Description: 输入整数数组 arr ，找出其中最小的 k 个数
 */
public class Solution2 {

    public int[] getLeastNumbers(int[] arr, int k){
        //java.util.PriorityQueue 默认为最小堆实现
        //PriorityQueue 构造函数传入Collections.reverseOrder(), 则按最大堆的逻辑进行构建
        //Collections.reverseOrder() 反向比较器
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //现将k个元素放进优先队列中
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        //数组余下的元素和pq最大的元素进行比较
        for (int i = k; i < arr.length; i++) {
            //如果数组元素比优先队列中最大的元素小的话
            if(!pq.isEmpty() && arr[i] < pq.peek()){
                //优先队列中最大元素出队
                pq.remove();
                //将数组元素放入优先队列中
                pq.add(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
    }
}
