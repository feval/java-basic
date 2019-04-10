package com.bittech.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ClassAnnotation(name = Apple.class)
class ObjectFactory {
    private ObjectFactory() {
    }
    public static <T> T getInstance() {
        ClassAnnotation classAnnotation =
                ObjectFactory.class.getAnnotation(ClassAnnotation.class);
        Class cls = classAnnotation.name();
        try {
            return (T) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassAnnotation {
    Class name();
}