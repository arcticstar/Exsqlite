package com.auxgroup.exsqlite.entities;

/**
 * Created by Administrator on 2016-2-18.
 */
public class Person {
    private int id;

    public Person() {
    }

    public Person( int id, String name,int age) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
