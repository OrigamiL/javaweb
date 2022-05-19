package com.weifang.javaweb.jsp.bean;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private boolean sex;
    private Address address;

    public Address getAddr() {
        return address;
    }

    public void setAddr(Address address) {
        this.address = address;
    }

    public User() {
    }

    public User(String username, String password, boolean sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals方法执行了");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password)&&Objects.equals(sex, user.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, sex);
    }

    public String getEmail(){
        return "zhezhi@buaa.edu.cn";
    }
}
