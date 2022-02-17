package com.yibo.datastructure.maxheap;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2022/2/17 23:45
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]){
                throw new RuntimeException("Error");
            }
        }

        System.out.println("Test MaxHeap completed.");
    }
}
