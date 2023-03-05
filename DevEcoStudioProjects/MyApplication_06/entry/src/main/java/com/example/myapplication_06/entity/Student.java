package com.example.myapplication_06.entity;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.Index;
import ohos.data.orm.annotation.PrimaryKey;

@Entity(tableName = "student",
        indices = {@Index(value = {"studentId"} ,
                name = "studentId_index",
                unique = true
        )})
public class Student extends OrmObject {
//    此处将userId设置为自增主键，注意只有在数据类型为包装类的时候，自增主键才生效。
    @PrimaryKey(autoGenerate = true)
    private Integer studentId;
    private String age;
    private boolean sex;

    public Student(Integer studentId, String age, boolean sex) {
        this.studentId = studentId;
        this.age = age;
        this.sex = sex;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", age='" + age + '\'' +
                ", sex=" + sex +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
