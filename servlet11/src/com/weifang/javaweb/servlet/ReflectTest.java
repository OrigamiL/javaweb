package com.weifang.javaweb.servlet;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.weifang.javaweb.servlet.HelloServlet");
            if(clazz.isAnnotationPresent(WebServlet.class)){
                WebServlet annotation = clazz.getAnnotation(WebServlet.class);
                String name = annotation.name();
                WebInitParam[] webInitParams = annotation.initParams();
                String[] value = annotation.value();
                System.out.println(name);
                for (String v :
                        value) {
                    System.out.println(v);
                }
                for (WebInitParam w :
                        webInitParams) {
                    System.out.println(w.name()+"="+w.value());
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
