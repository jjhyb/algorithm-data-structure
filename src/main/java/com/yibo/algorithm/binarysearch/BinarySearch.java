package com.yibo.algorithm.binarysearch;

/**
 * @Author: huangyibo
 * @Date: 2022/1/23 16:42
 * @Description: 二分查找法 递归实现方式
 */
public class BinarySearch {

    /**
     * 递归方式二分查找法 找到返回元素索引，没找到返回-1
     * @param data 目标数组
     * @param target 目标值
     * @param <E> 泛型
     * @return 返回目标值索引
     */
    public static <E extends Comparable<E>> int binarySearch(E[] data,E target){
        return search(data,0,data.length - 1,target);
    }

    /**
     * 递归方式二分查找法 找到返回元素索引，没找到返回-1
     * @param data 目标数组
     * @param left 左边界索引
     * @param right 右边界索引
     * @param target 目标值
     * @param <E> 泛型
     * @return 返回目标值索引
     */
    private static <E extends Comparable<E>> int search(E[] data, int left, int right, E target){
        if(left > right){
            return -1;
        }
        int mid = (left + right) >>> 1;
        if(data[mid].compareTo(target) > 0){
            return search(data,left,mid - 1,target);
        }else if(data[mid].compareTo(target) < 0) {
            return search(data,mid + 1,right,target);
        }
        //mid索引元素和目标值相等
        return mid;
    }
}
