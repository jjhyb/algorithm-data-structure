package com.yibo.algorithm.binarysearch;

/**
 * @Author: huangyibo
 * @Date: 2022/1/23 16:42
 * @Description: 二分查找法 非递归实现方式
 * 文字描述:
 * 1、前提：数组需有序
 * 2、定义左边界L, 右边界R, 确定搜索范围, 执行二分查找
 * 3、获取中间索引 M = (L + R) / 2
 * 4、中间索引的值 A[M] 与待搜索的值 T 进行比较
 *      1、A[M] == T 表示找到, 返回中间索引
 *      2、A[M] >  T 中间值右侧的其他元素都大于 T, 无需比较, 中间索引左边去找, M - 1 设置为右边界, 重新查找
 *      3、A[M] <  T 中间值左侧的其他元素都小于 T, 无需比较, 中间索引右边去找, M + 1 设置为左边界, 重新查找
 * 5、当 L > R 时, 表示没有找到, 应结束循环
 *
 * 注意:
 * 1、目前二分查找是以JDK中的 Arrays.binarySearch()为实现
 * 2、实际上二分查找有诸多变体，一旦使用变体的实现代码，则左右边界的选取会有变化
 */
public class BinarySearch2 {

    /**
     * 二分查找，找到返回元素索引，没找到返回-1
     * @param data 目标数组
     * @param target 目标值
     * @param <E> 泛型
     * @return 返回目标值索引
     */
    public static <E extends Comparable<E>> int binarySearch(E[] data,E target){
        int left = 0;
        int right = data.length - 1;

        while (left <= right){
            //left、right 值特别大，会有溢出风险
            //int mid = (left + right) / 2;

            //这种写法不会溢出
            //int mid = left + (right - left) / 2;

            //使用位运算，正整数无符号右移一位和除2效果一样，效率更高
            int mid = (left + right) >>> 1;

            if(data[mid].compareTo(target) == 0){
                return mid;
            }else if(data[mid].compareTo(target) > 0){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
