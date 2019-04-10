package com.bittech.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestAnnotationFactory {

    public static void main(String[] args) {
//        Fruit fruit = FruitFactory.getInstance();
//        fruit.eat();

        Fruit fruit =ObjectFactory.getInstance();
        fruit.eat();
    }

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface FruitAnnotation {
    Class name();
}

@FruitAnnotation(name = Apple.class)
interface Fruit {
    void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("苹果");
    }
}

class FruitFactory {
    private FruitFactory() {

    }

    public static Fruit getInstance() {
        FruitAnnotation fruitAnnotation = Fruit.class.getAnnotation(FruitAnnotation.class);
        Class cls = fruitAnnotation.name();
        try {
            return (Fruit) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}


