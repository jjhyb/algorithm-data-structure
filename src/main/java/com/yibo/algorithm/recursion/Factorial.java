package com.yibo.algorithm.recursion;

/**
 * @Author: huangyibo
 * @Date: 2024/11/10 19:03
 * @Description: 阶乘
 */
public class Factorial {

    public static int f(int n){
        if(n <= 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
