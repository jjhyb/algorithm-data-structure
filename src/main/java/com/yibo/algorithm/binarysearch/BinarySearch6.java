package com.yibo.algorithm.binarysearch;

/**
 * @Author: huangyibo
 * @Date: 2022/1/23 23:07
 * @Description: 二分查找法变种 查找小于目标值的最大值
 */
public class BinarySearch6 {

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 8, 11, 11, 11, 22, 31, 35, 40, 45, 48, 49, 50};

        int search = lower(arr, 22);
        System.out.println(search);
    }

    /**
     * 查找小于目标值的最大值
     * @param data 目标数组
     * @param target 目标值
     * @param <E> 泛型
     * @return 返回比目标值小的最大值的索引
     */
    public static <E extends Comparable<E>> int lower(E[] data,E target){
        int left = -1;
        int right = data.length - 1;
        //在data[left, right]中寻找解
        while (left < right){
            //如果目标数组为{1, 1, 8, 11, 11, 11, 22,}, 目标值target为2或22，那么会陷入死循环
            //这里采用这种方式获取mid的值的原因在于
            //比目标值小的最大值存在多个的话，mid = (left + right) >>> 1
            //mid的值取得是左边界的值，那么会陷入死循环中
            //mid = (left + right + 1) >>> 1 mid的值取的是右边界的值，会规避死循环的问题
            //int mid = left + (right - left + 1) / 2;
            int mid = (left + right + 1) >>> 1;
            if(data[mid].compareTo(target) < 0){
                //mid索引元素小于等于目标值，
                //比目标值小的最大值在其右边区间，有可能就是mid索引的值
                left = mid;
            }else{
                //mid索引元素大于等于目标值，比目标值小的最大值在其左边区间
                right = mid - 1;
            }
        }
        return left;
    }
}
