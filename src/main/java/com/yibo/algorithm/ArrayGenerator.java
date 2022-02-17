package com.yibo.algorithm;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2021/12/22 0:33
 * @Description: 数组生成工具类
 */
public class ArrayGenerator {

    /**
     * 生成一个长度为num的有序数组，每个数字的范围是[0,num)范围
     * @param num
     * @return
     */
    public static Integer[] generatorOrderedArray(int num){
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个长度为num的随机数组，每个数字的范围是[0,bound)范围
     * @param num
     * @param bound
     * @return
     */
    public static Integer[] generatorRandomArray(int num,int bound){
        Integer[] arr = new Integer[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
