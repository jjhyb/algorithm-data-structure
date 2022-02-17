package com.yibo.algorithm.binarysearch;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2022/1/24 0:58
 * @Description: 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 */
public class Solution3 {

    public static void main(String[] args) {
        //int[] piles = {1,2,3,4,5,6,7,8,9,10};
        //int[] piles = {3,2,2,4,1,4};
        int[] piles = {1,2,3,1,1};
        Solution3 solution = new Solution3();
        int hour = solution.shipWithinDays(piles, 4);
        System.out.println(hour);
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right){
            int mid = (left + right) >>> 1;
            if(days(weights,mid) <= days){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int days(int[] weights, int capacity){
        int days = 0;
        int load = 0;
        for (int i = 0; i < weights.length; i++) {
            load =  load + weights[i];
            if(load > capacity){
                i--;
                days ++;
                load = 0;
            }
            if(load == capacity){
                days ++;
                load = 0;
            }
            if(i == weights.length - 1 && load < capacity){
                days ++;
            }
        }
        return days;
    }
}
