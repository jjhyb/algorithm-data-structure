package com.yibo.algorithm.selectionsort;

/**
 * @Author: huangyibo
 * @Date: 2021/12/21 21:45
 * @Description:
 */
public class Student implements Comparable<Student> {

    private String name;

    private int score;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        Student student = (Student)obj;
        return this.name.equals(student.getName());
    }

    public int compareTo(Student student) {
        /*if(this.score < student.score){
            return -1;
        }else if(this.score == student.score){
            return 0;
        }
        return 1;*/
        return this.score - student.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
