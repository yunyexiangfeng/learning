package com.java.compareTo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.java.compareTo
 * @ClassName: Person
 * @Description: 将配置文件的每一个属性值，映射到该组件中
 *              @ConfigurationProperties : 只能使用容器中的组件
 *                      prefix：指定配置文件中的字面量前缀
 * @Author: Administrator
 * @CreateDate: 2019/12/7 14:21
 */
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    private String name;
    private int age;
    private int sex;

    private Map<String, Object> maps;
    private List<String> pets;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", maps=" + maps +
                ", pets=" + pets +
                '}';
    }
}
