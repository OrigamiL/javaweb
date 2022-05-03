package com.weifang.reflectAll.reflectJk;

public class Jk {
    public Jk() {
        System.out.println("NOOP & public constructor");
    }
    private Jk(int a, String b) {
        System.out.println("private constructor& parameter : "+a+",parameter : "+b);
    }
    private Jk(int a) {
        System.out.println("private constructor & parameter : "+a);
    }

}
