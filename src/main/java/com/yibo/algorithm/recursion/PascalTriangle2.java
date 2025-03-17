package com.yibo.algorithm.recursion;

/**
 * @Author: huangyibo
 * @Date: 2024/11/25 0:06
 * @Description: 杨辉三角——使用一维数组记忆法优化 (动态规划优化)
 */
public class PascalTriangle2 {

    /**
     * 打印杨辉三角
     * @param n 杨辉三角的高度
     */
    public static void print(int n){
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            createRow(row, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d",row[j]);
            }
            System.out.println();
        }
    }

    /**
     * 计算杨辉三角的每一行的值，用已计算下一行的值
     * 1   0   0   0   0
     * 1   1   0   0   0
     * 1   2   1   0   0
     * 1   3   3   1   0
     * 1   4   6   4   1
     * @param row
     * @param i
     */
    private static void createRow(int[] row, int i) {
        if(i == 0) {
            row[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            row[j] = row[j] + row[j - 1];
        }
    }

    /**
     * 打印杨辉三角的空格，形成杨辉三角形态
     * @param n 杨辉三角的高度
     * @param i 杨辉三角的当前行
     */
    public static void printSpace(int n, int i){
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        print(5);
    }
}
