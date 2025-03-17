package com.yibo.algorithm.recursion;


import java.util.LinkedList;

/**
 * @Author: huangyibo
 * @Date: 2024/11/24 23:46
 * @Description: 汉诺塔问题
 */
public class HanoiTower {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    public static void init(int n){
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    /**
     * 圆盘移动
     * @param n 圆盘个数
     * @param a 源
     * @param b 借
     * @param c 目的
     */
    public static void move(int n, LinkedList<Integer> a,
                            LinkedList<Integer> b,
                            LinkedList<Integer> c){
        if(n <= 0){
            return;
        }
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print();
        move(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        init(3);
        print();
        move(3, a, b, c);
    }

    private static void print() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }


}
