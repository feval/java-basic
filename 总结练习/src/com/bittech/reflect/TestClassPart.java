package com.bittech.reflect;

import com.bittech.TestPerson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestClassPart {


    public static void codePart1() {
        Class classz = Message.class;

        //获取类的包名
        Package pg = classz.getPackage();
        System.out.println(pg.getName());
        System.out.println(pg.toString());

        //获取类的名称
        //包名+类名 = 类的全限定名
        System.out.println(classz.getName());
        //类名
        System.out.println(classz.getSimpleName());

        //父类(extends)
        Class superClass = classz.getSuperclass();
        System.out.println("父类的名称：" + superClass.getName());
        System.out.println("父类的包名：" + superClass.getPackage().getName());

        //接口(implements)
        Class[] interfacesClass = classz.getInterfaces();
        for (Class cls : interfacesClass) {
            System.out.println("接口名称：" + cls.getName());
        }
    }

    public static void codePart2() {
        Class classz = Message.class;
        //获取classz的所有构造方法
        Constructor[] constructors = classz.getConstructors();
        for (Constructor constructor : constructors) {
            //1. 遍历数组，通过StringBuilder拼接
            //2. Arrays
            Class[] parameterTypes = constructor.getParameterTypes();
            String parameters = Arrays.toString(parameterTypes);
            System.out.println(constructor.getName() + "(" + parameters + ")");
        }

        System.out.println("--------");

        //获取指定的构造方法
        try {
            Constructor constructor = classz.getConstructor(String.class, Integer.class);
            System.out.println(constructor);

            //通过构造方法对象获取实例化对象
            Object object = constructor.newInstance("zhangsan", 20);
//            System.out.println(object);
//            System.out.println(object.getClass());
            Message message = (Message) object;
            System.out.println(message);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void codePart3() {
        //Class对象获取方法
        Class classz = Person2.class;
        /*
        Method[] methods = classz.getMethods();

        for (Method method : methods) {
            System.out.println(method.getName() + " "
                    + Arrays.toString(method.getParameterTypes()));
        }
        */

        try {
            Method method = classz.getMethod("setName", String.class);
            Person2 person2 = new Person2("Jack", 22);
            System.out.println("before:" + person2);
            Object returnValue = method.invoke(person2, "Tom");
            System.out.println(returnValue);
            System.out.println("after:" + person2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void codePart4() {
        //获取属性（字段）
        Student student = new Student();
        student.setName("Jack");
        student.setAge(22);
        student.setSkill("C++,PHP,Java");

        Class studentClass = student.getClass();
        //获取父类的公开的属性（字段）
        /*
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " " + field.getType());
        }

        try {
            Field nameField = studentClass.getField("name");
            System.out.println(nameField.getName() + " " +nameField.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        */

        //获取当前类
        /*
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " " + field.getType());
        }
        try {
            Field fields1 = studentClass.getDeclaredField("skill");
            System.out.println(fields1.getName() + " " + fields1.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        */

        //获取student对象的skill属性
        System.out.println("skill = " + student.getSkill());
        try {
            Field skillField = studentClass.getDeclaredField("skill");
            //get
            //set
            //public能够直接访问
            //private
            skillField.setAccessible(true);
            Object skillValue = skillField.get(student);
//            if(skillValue instanceof String){
//
//            }
            System.out.println(skillValue);

            skillField.set(student, "JavaScript");

            System.out.println(student.getSkill());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {



    }

}


interface IMessage {

}

interface OperatorSystem {

}

class ChatMessage {

}

class Message extends ChatMessage implements IMessage, OperatorSystem {
    private String name;
    private Integer age;

    //()
    public Message() {

    }

    //(String,Integer)
    public Message(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //(Integer,String)
    public Message(Integer age, String name) {
        this(name, age);
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
        return "Message{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Person2 {

    private String name;
    public Integer age;

    public Person2() {

    }

    public Person2(String name, Integer age) {
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

    public String greetInfo() {
        return "欢迎" + this.getName();
    }

    public void printPersonInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person2 {
    private String skill;
    private String mobilePhone;
    public boolean gender;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Student{" +
                "skill='" + skill + '\'' +
                '}';
    }
}