package com.yibo.algorithm.binarysearch;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author: huangyibo
 * @Date: 2022/1/24 0:38
 * @Description: 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例 3：
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        Solution2 solution2 = new Solution2();
        int hour = solution2.minEatingSpeed(piles, 5);
        System.out.println(hour);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left < right){
            int mid = (left + right) >>> 1;
            if(eatingTime(piles,mid) <= h){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int eatingTime(int[] piles, int k){
        int hour = 0;
        for (int pile : piles) {
            hour += pile % k == 0 ? pile / k : pile / k + 1;
        }
        return hour;
    }
}
