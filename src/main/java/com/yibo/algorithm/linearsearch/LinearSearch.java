package com.yibo.algorithm.linearsearch;

import com.yibo.algorithm.ArrayGenerator;

/**
 * @Author: huangyibo
 * @Date: 2021/12/21 20:37
 * @Description:
 */
public class LinearSearch {

    public static <E> int search(E[] data, E target){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int num = 1000000;
        Integer[] data = ArrayGenerator.generatorOrderedArray(num);
        long startTime = System.nanoTime();
        int index = search(data, num);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println(time);
    }
}
