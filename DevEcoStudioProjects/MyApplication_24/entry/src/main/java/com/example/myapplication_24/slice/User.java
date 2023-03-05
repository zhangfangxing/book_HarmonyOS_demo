package com.example.myapplication_24.slice;

public class User {

    private String name;
    private String age;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public User(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
