package com.yibo.algorithm;

import com.yibo.algorithm.bubblesort.*;
import com.yibo.algorithm.heapsort.HeapSort2;
import com.yibo.algorithm.insertionsort.InsertionSort;
import com.yibo.algorithm.mergesort.*;
import com.yibo.algorithm.quicksort.*;
import com.yibo.algorithm.selectionsort.SelectionSort;
import com.yibo.algorithm.heapsort.HeapSort;
import com.yibo.algorithm.shellsort.ShellSort;
import com.yibo.algorithm.shellsort.ShellSort2;
import com.yibo.algorithm.shellsort.ShellSort3;
import com.yibo.algorithm.shellsort.ShellSort4;

/**
 * @Author: huangyibo
 * @Date: 2021/12/23 1:09
 * @Description:
 */
public class SortingHelper {

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i].compareTo(arr[i + 1]) > 0){
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName,E[] arr){
        long startTime = System.nanoTime();
        if("SelectionSort".equals(sortName)){
            SelectionSort.selectionSort(arr);
        }else if("InsertionSort".equals(sortName)){
            InsertionSort.insertionSort(arr);
        }else if("MergeSort".equals(sortName)){
            MergeSort.mergeSort(arr);
        }else if("MergeSort2".equals(sortName)){
            MergeSort2.mergeSort(arr);
        }else if("MergeSort3".equals(sortName)){
            MergeSort3.mergeSort(arr);
        }else if("MergeSort4".equals(sortName)){
            MergeSort4.mergeSort(arr);
        }else if("MergeSort5".equals(sortName)){
            MergeSort5.mergeSort(arr);
        }else if("QuickSort".equals(sortName)){
            QuickSort.quickSort(arr);
        }else if("QuickSort2".equals(sortName)){
            QuickSort2.quickSort(arr);
        }else if("QuickSort3".equals(sortName)){
            QuickSort3.quickSort(arr);
        }else if("QuickSort4".equals(sortName)){
            QuickSort4.quickSort(arr);
        }else if("QuickSort5".equals(sortName)){
            QuickSort5.quickSort(arr);
        }else if("HeapSort".equals(sortName)){
            HeapSort.heapSort(arr);
        }else if("HeapSort2".equals(sortName)){
            HeapSort2.heapSort(arr);
        }else if("BubbleSort".equals(sortName)){
            BubbleSort.bubbleSort(arr);
        }else if("BubbleSort2".equals(sortName)){
            BubbleSort2.bubbleSort(arr);
        }else if("BubbleSort3".equals(sortName)){
            BubbleSort3.bubbleSort(arr);
        }else if("BubbleSort4".equals(sortName)){
            BubbleSort4.bubbleSort(arr);
        }else if("BubbleSort5".equals(sortName)){
            BubbleSort5.bubbleSort(arr);
        }else if("ShellSort".equals(sortName)){
            ShellSort.shellSort(arr);
        }else if("ShellSort2".equals(sortName)){
            ShellSort2.shellSort(arr);
        }else if("ShellSort3".equals(sortName)){
            ShellSort3.shellSort(arr);
        }else if("ShellSort4".equals(sortName)){
            ShellSort4.shellSort(arr);
        }


        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if(!isSorted(arr)){
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(sortName + ", " + time + "S");
    }
}
