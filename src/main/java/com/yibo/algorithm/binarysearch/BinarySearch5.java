package com.yibo.algorithm.binarysearch;

/**
 * @Author: huangyibo
 * @Date: 2022/1/23 22:38
 * @Description: 二分查找法变种
 * 前提：有序数组中存在重复元素
 * 1、目标值在有序数组中存在多个，返回最小索引
 * 2、目标值在有序数组中不存在，返回比目标值大的索引
 */
public class BinarySearch5 {

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 8, 11, 11, 11, 22, 31, 35, 40, 45, 48, 49, 50};

        int search = lowerCeil(arr, 11);
        System.out.println(search);
    }

    /**
     * 1、目标值在有序数组中存在多个，返回最小索引
     * 2、目标值在有序数组中不存在，返回比目标值大的索引
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int lowerCeil(E[] data,E target){
        //获取到比目标值大的最小值的索引
        int upper = upper(data, target);
        //声明临时变量，temp
        int temp = upper - 1;
        //循环的前提是temp >= 0
        while (temp >= 0){
            //如果temp索引的元素等于目标值，说明目标在在数组中存在
            if(data[temp].compareTo(target) == 0){
                temp -- ;
            }else if(data[temp].compareTo(target) < 0){
                //如果temp索引的元素小于目标值，则跳出循环
                break;
            }
        }

        //数组中元素不存在目标值
        return temp + 1;
    }

    /**
     * 查找比目标值大的最小值的索引
     * @param data 目标数组
     * @param target 目标值
     * @param <E> 泛型
     * @return 返回比目标值大的最小值的索引
     */
    private static <E extends Comparable<E>> int upper(E[] data,E target){
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
}
