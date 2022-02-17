package com.yibo.algorithm.linearsearch;

/**
 * @Author: huangyibo
 * @Date: 2021/12/21 21:46
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        int result1 = LinearSearch.search(data, 16);
        System.out.println(result1);

        Student[] students = {new Student("张无忌"),
                new Student("令狐冲"),
                new Student("段誉"),
                new Student("叶孤城")};
        int result2 = LinearSearch.search(students, new Student("张无忌Test"));
        System.out.println(result2);
    }
}
