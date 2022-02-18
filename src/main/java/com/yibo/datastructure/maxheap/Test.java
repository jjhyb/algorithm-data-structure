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
        Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, false);
        System.out.println("without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("with heapify: " + time2 + " s");
    }

    public static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (Integer data : testData) {
                maxHeap.add(data);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if(arr[i] > arr[i - 1]){
                throw new RuntimeException("Error");
            }
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
