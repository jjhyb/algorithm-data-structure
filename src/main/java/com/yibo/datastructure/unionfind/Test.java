package com.yibo.datastructure.unionfind;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2022/2/26 14:53
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
        /*UnionFind1 unionFind1 = new UnionFind1(size);
        System.out.println("UnionFind1: " + testUF(unionFind1,m) +" s");

        UnionFind2 unionFind2 = new UnionFind2(size);
        System.out.println("UnionFind2: " + testUF(unionFind2,m) +" s");*/

        UnionFind3 unionFind3 = new UnionFind3(size);
        System.out.println("UnionFind3: " + testUF(unionFind3,m) +" s");

        UnionFind4 unionFind4 = new UnionFind4(size);
        System.out.println("unionFind4: " + testUF(unionFind4,m) +" s");

        UnionFind5 unionFind5 = new UnionFind5(size);
        System.out.println("unionFind5: " + testUF(unionFind5,m) +" s");

        UnionFind6 unionFind6 = new UnionFind6(size);
        System.out.println("unionFind6: " + testUF(unionFind6,m) +" s");
    }

    private static double testUF(IUnionFind uf, int m){
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
