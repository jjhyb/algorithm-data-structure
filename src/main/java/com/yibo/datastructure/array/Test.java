package com.yibo.datastructure.array;

/**
 * @Author: huangyibo
 * @Date: 2021/12/25 18:03
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(5);
        System.out.println(arr);
    }
}
