package com.yibo.algorithm.linearsearch;

/**
 * @Author: huangyibo
 * @Date: 2021/12/21 21:45
 * @Description:
 */
public class Student {

    private String name;

    public Student (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
