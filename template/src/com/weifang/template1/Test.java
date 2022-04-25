package com.weifang.template1;

public class Test {
    public static void main(String[] args) {
        Person student = new Student();
        Person teacher = new Teacher();
        student.day();
        System.out.println("==============");
        teacher.day();
    }
}
