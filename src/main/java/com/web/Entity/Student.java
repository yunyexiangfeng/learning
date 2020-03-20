package com.web.Entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.web.Entity
 * @ClassName: Student
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/3/17 15:03
 */
@Entity
public class Student {

    @Id()
    @Column(name = "s_id")
    private String id;

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_birth")
    private String birth;

    @Column(name = "s_sex")
    private String sex;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
