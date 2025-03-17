package com.yibo.algorithm.recursion;

/**
 * @Author: huangyibo
 * @Date: 2024/11/25 0:06
 * @Description: 杨辉三角——使用二维数组记忆法优化
 */
public class PascalTriangle1 {

    /**
     * 求解杨辉三角某一个行和列的值
     * @param i 代表行
     * @param j 代表列
     * @return
     */
    private static int element(int[][] triangle, int i, int j){
        if(triangle[i][j] > 0){
            return triangle[i][j];
        }
        if(j == 0 || i == j){
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = element(triangle,i - 1, j -1) + element(triangle,i - 1, j);
        return triangle[i][j];
    }

    /**
     * 打印杨辉三角
     * @param n 杨辉三角的高度
     */
    public static void print(int n){
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d",element(triangle, i, j));
            }
            System.out.println();
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
