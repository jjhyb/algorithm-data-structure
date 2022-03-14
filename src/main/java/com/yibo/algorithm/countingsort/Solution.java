package com.yibo.algorithm.countingsort;

/**
 * @Author: huangyibo
 * @Date: 2022/3/13 15:49
 * @Description: 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 */
public class Solution {

    public void sortColors(int[] nums) {
        //处理元素取值范围 [0, R) 的计数排序
        int R = 3;
        int[] count = new int[R];
        for (int num : nums) {
            count[num] ++;
        }

        //[index[i], index[i + 1])的值为i
        int[] index = new int[R + 1];
        for (int i = 0; i < R; i++) {
            index[i + 1] = index[i] + count[i];
        }
        for (int i = 0; i + 1 < index.length; i++) {
            for(int j = index[i]; j < index[i + 1]; j++){
                nums[j] = i;
            }
        }
    }
}
