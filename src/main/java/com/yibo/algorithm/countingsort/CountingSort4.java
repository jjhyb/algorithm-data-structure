package com.yibo.algorithm.countingsort;

/**
 * @Author: huangyibo
 * @Date: 2022/3/13 15:48
 * @Description: 计数排序
 */
public class CountingSort4 {

    public void countSort(Student[] students) {
        int R = 101;
        int[] count = new int[R];
        for (Student student : students) {
            count[student.getScore()] ++;
        }

        int[] index = new int[R + 1];
        for (int i = 0; i < R; i++) {
            index[i + 1] = index[i] + count[i];
        }
        Student[] temp = new Student[students.length];
        for (Student student : students) {
            temp[index[student.getScore()]] = student;
            index[student.getScore()] ++;
        }
        for (int i = 0; i < students.length; i++) {
            students[i] = temp[i];
        }
    }
}
