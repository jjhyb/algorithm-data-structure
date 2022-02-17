package com.yibo.algorithm.binarysearch;

/**
 * @Author: huangyibo
 * @Date: 2022/1/23 22:25
 * @Description: 二分查找法变种 查找比目标值大的最小值
 */
public class BinarySearch3 {

    /**
     * 查找比目标值大的最小值的索引
     * @param data 目标数组
     * @param target 目标值
     * @param <E> 泛型
     * @return 返回比目标值大的最小值的索引
     */
    public static <E extends Comparable<E>> int upper(E[] data,E target){
        int left = 0;
        int right = data.length;
        //在data[left, right]中寻找解
        while (left < right){
            int mid = (left + right) >>> 1;
            if(data[mid].compareTo(target) <= 0){
                //mid索引元素小于等于目标值，比目标值大的最小值在其右边区间
                left = mid + 1;
            }else {
                //mid索引元素大于目标值，
                //比目标值大的最小值在其左边区间，有可能就是mid索引的值
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};

        int search = upper(arr, 48);
        System.out.println(search);
    }
}
