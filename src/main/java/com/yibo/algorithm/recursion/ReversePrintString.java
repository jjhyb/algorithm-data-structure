package com.yibo.algorithm.recursion;

/**
 * @Author: huangyibo
 * @Date: 2024/11/10 19:13
 * @Description:
 */
public class ReversePrintString {

    public static void fn(int n, String str) {
        if(n >= str.length()){
            return;
        }
        fn(n+1, str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        fn(0, "12345");
    }
}
