package com.collection.list;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/14 18:52
 */
class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person per = (Person) obj;
        return per.age.equals(this.age) && per.name.equals(this.name);
    }
}

public class ListTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三", 12));
        list.add(new Person("李四", 14));
        list.add(new Person("王五", 61));
        System.out.println(list.contains(new Person("张三", 12)));
        System.out.println(list.remove(new Person("王五", 61)));
    }
}
