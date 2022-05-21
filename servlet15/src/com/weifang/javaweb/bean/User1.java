package com.weifang.javaweb.bean;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/*
        该监听器不需要使用@WebListener进行标注 当User对象被放入session域中的时候触发bind事件 当User对象从session域中删除的时候 触发unbind事件
 */

public class User1 implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("绑定数据");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解绑数据");
    }

    private String usercode;
    private String username;
    private String password;

    public User1() {
    }

    public User1(String usercode, String username, String password) {
        this.usercode = usercode;
        this.username = username;
        this.password = password;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}