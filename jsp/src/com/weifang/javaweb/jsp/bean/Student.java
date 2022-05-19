package com.weifang.javaweb.jsp.bean;

import java.util.Objects;

public class Student {
    private String no;
    private String name;

    public Student() {
    }

    public Student(String no, String name) {
        this.no = no;
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(no, student.no) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
