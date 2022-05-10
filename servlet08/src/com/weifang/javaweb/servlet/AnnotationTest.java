package com.weifang.javaweb.servlet;

import java.util.Arrays;

@MyAnnotation(s={Season.AUTUMN})
public class AnnotationTest {
    public static void main(String[] args) {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
            Season[] s = annotation.s();
            System.out.println(Arrays.toString(s));
        }
    }
}

