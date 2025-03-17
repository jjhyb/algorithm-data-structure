package com.yibo.algorithm.recursion;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2024/11/19 22:06
 * @Description: 斐波那契数列
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fn(8));
        System.out.println(fn1(5));
        System.out.println(fn2(5));
    }

    public static int fibonacci(int n){
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    /**
     * 斐波那契数列 记忆法优化
     * @param n
     * @return
     */
    public static int f(int n, int[] cache){
        if(cache[n] != -1) {
            return cache[n];
        }
        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public static int fn(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int x = fn(n - 1);
        int y = fn(n - 2);
        return x + y;
    }

    /**
     * 斐波那契数列，兔子繁殖
     * @param n
     * @return
     */
    public static int fn1(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int x = fn1(n - 1);
        int y = fn1(n - 2);
        return x + y;
    }

    /**
     * 斐波那契数列，兔子繁殖
     * @param n
     * @return
     */
    public static int fn2(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int x = fn2(n - 1);
        int y = fn2(n - 2);
        return x + y;
    }
}
